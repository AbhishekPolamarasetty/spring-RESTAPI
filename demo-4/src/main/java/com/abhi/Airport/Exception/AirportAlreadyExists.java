package com.abhi.Airport.Exception;

import java.util.HashMap;

public class AirportAlreadyExists extends RuntimeException {
    
	private String message;
	public AirportAlreadyExists(String message) {
		super(message);
		this.message=message;
		// TODO Auto-generated constructor stub
	}
	public AirportAlreadyExists() {
		// TODO Auto-generated constructor stub
	}
   
	public HashMap<String,String> getinfo(String status){
		 HashMap<String,String> hmap= new HashMap<>();
				 hmap.put("message", message);
				 hmap.put("httpstatus", status);
		return hmap ;
	}
}
