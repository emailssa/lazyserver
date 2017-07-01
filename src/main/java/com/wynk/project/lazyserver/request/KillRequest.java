package com.wynk.project.lazyserver.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KillRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6268478344252553080L;
	private int connid;

	public int getConnid() {
		return connid;
	}

	public void setConnid(int connid) {
		this.connid = connid;
	}
	
	
}
