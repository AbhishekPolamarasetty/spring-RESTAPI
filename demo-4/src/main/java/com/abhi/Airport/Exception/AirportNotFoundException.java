package com.abhi.Airport.Exception;


import java.util.HashMap;

public class AirportNotFoundException extends RuntimeException{

    private String errorMsg ;	
    
	public AirportNotFoundException(String message) {
		super(message);
		this.errorMsg=message;
	
	}
	
	public HashMap<String,String> getMes(String status,String location){
		 HashMap<String,String> hmap= new HashMap<>();
				 hmap.put("message", errorMsg);
				 hmap.put("httpstatus", status);
				 hmap.put("location", location);
		return hmap ;
	}
	
}
