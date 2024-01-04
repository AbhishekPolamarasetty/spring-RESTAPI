package com.restwithmysql.Exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CloudVendorException {
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
	
	public CloudVendorException(String message, Throwable throwable, HttpStatus httpStatus) {
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}
	
}
