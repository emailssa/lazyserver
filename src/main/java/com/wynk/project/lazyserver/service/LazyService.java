package com.wynk.project.lazyserver.service;

import java.util.Map;

import com.wynk.project.lazyserver.response.LazyResponse;

public interface LazyService {

	LazyResponse sleep(int connectionId, int timeout);
	
	Map<Integer, LazyResponse> serverStatus();
	
	void kill(int connectionId);

}
