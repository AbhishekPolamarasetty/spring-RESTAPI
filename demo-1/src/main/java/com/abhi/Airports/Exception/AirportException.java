package com.abhi.Airports.Exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class AirportException {
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
	
	public AirportException(String message, Throwable throwable, HttpStatus httpStatus) {
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}
	
}
