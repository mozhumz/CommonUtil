package com.hyj.util.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException {
	private String msg;
	private Integer code;

	public BaseException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public BaseException() {
	}

	public BaseException( Integer code,String msg) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public BaseException( String msg,Integer code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

}
