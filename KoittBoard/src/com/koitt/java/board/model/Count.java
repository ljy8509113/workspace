package com.koitt.java.board.model;

import java.io.Serializable;

public class Count implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer count;

	public Count(Integer count) {
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
