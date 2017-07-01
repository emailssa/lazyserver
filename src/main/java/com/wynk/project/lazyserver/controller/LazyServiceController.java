package com.wynk.project.lazyserver.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wynk.project.lazyserver.request.KillRequest;
import com.wynk.project.lazyserver.response.LazyResponse;
import com.wynk.project.lazyserver.service.LazyService;

@RestController
public class LazyServiceController {

	@Autowired
	private LazyService lazyService;

	@RequestMapping(value = "/sleep", method = RequestMethod.GET)
	public LazyResponse sleep(@RequestParam("timeout") int timeout, @RequestParam("connid") int connectionId)
			throws Exception {
		return lazyService.sleep(connectionId, timeout);
	}

	@RequestMapping(value = "/serverstatus", method = RequestMethod.GET)
	public Map<Integer, LazyResponse> serverStatus() throws Exception {
		return lazyService.serverStatus();
	}

	@RequestMapping(value = "/kill", method = RequestMethod.POST)
	public void kill(@RequestBody KillRequest killRequest) throws Exception {
		lazyService.kill(killRequest.getConnid());
	}

}
