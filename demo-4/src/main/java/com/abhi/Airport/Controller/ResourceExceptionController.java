package com.abhi.Airport.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.abhi.Airport.Exception.ResourceConflictException;

@RestControllerAdvice
public class ResourceExceptionController {
	@ExceptionHandler(ResourceConflictException.class)
    public ResponseEntity<String> handleResourceConflict(ResourceConflictException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}


 

