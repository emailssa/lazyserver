package com.wynk.project.lazyserver.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wynk.project.lazyserver.constants.ResponseStatus;
import com.wynk.project.lazyserver.response.LazyResponse;
import com.wynk.project.lazyserver.service.LazyService;

@Service
public class LazrServiceImpl implements LazyService {

	private Map<Integer, LazyResponse> connectionMap = new ConcurrentHashMap<>();
	private static final Logger logger = LoggerFactory.getLogger(LazrServiceImpl.class);

	@Override
	public LazyResponse sleep(int connectionId, int timeout) {
		LazyResponse response = new LazyResponse();
		response.setStat(ResponseStatus.OK);
		response.setTimeout(timeout);
		if (!connectionMap.containsKey(connectionId)) {
			connectionMap.put(connectionId, response);
			synchronized (response) {
				try {
					while (response.getTimeout() > 0 && (response.getStat() == ResponseStatus.OK)) {
						response.decrementTime();
						response.wait(1000);
					}
				} catch (InterruptedException e) {
					logger.error(e.getMessage(), e);
				}
			}
		} else {
			return connectionMap.get(connectionId);
		}
		connectionMap.remove(connectionId);
		return response;
	}

	@Override
	public Map<Integer, LazyResponse> serverStatus() {
		return connectionMap;
	}

	@Override
	public void kill(int connectionId) {
		LazyResponse lazyResponse = connectionMap.get(connectionId);
		if (lazyResponse != null) {
			synchronized (lazyResponse) {
				lazyResponse.setStat(ResponseStatus.KILLED);
				lazyResponse.notify();
			}
		}

	}

}
