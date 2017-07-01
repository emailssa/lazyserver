package com.wynk.project.lazyserver.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wynk.project.lazyserver.constants.ResponseStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LazyResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7836446395936707841L;

	private ResponseStatus stat;

	private int timeout;

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public ResponseStatus getStat() {
		return stat;
	}

	public void setStat(ResponseStatus stat) {
		this.stat = stat;
	}

	public void decrementTime() {
		if (timeout > 0) {
			timeout--;
		}
	}
}
