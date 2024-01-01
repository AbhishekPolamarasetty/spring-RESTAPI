package com.abhi.Airport.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AirportExceptionHandler {
	@ExceptionHandler(value = {AirportNotFoundException.class})
	public ResponseEntity<Object> handleAirportNotFoundException (AirportNotFoundException airportNotFoundException){
		AirportException airportException = new AirportException(
				airportNotFoundException.getMessage(),
				airportNotFoundException.getCause(),
				HttpStatus.NOT_FOUND
				);
				return new ResponseEntity<>(airportException, HttpStatus.NOT_FOUND);
				
	}
}
