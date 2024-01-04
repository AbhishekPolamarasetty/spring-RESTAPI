package com.abhi.Airport.Controller;

import java.util.List;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.Airport.Entity.Airport;
import com.abhi.Airport.Exception.AirportAlreadyExists;
import com.abhi.Airport.Exception.AirportNotFoundException;
import com.abhi.Airport.Service.AirportService;

import lombok.extern.slf4j.Slf4j;

//import org.slf4j.Logger;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class AirportController{
	
//	private static final Logger logger = LoggerFactory.getLogger(AirportController.class);
	
	@Autowired
	private AirportService airportService;

	
	@GetMapping("/airports")
	public List<Airport> getAllAirportDetails() {
		log.info("Fetching all airport details.");
		return airportService.getAllAirports();
	}
	
	@PostMapping("/airports")
	public ResponseEntity<?> createAirportDetails(@RequestBody Airport airport) {
	    log.info("creating all airport details.");
	    try {
	    	airportService.createAirport(airport);
		    return ResponseEntity.status(HttpStatus.CREATED).body("Airport created successfully");
	    }
		catch (AirportAlreadyExists e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getinfo("409"));
		}
	    
	}

	
	@GetMapping("airport/{IATACODE}")
	public ResponseEntity<?> getAirportDetails(@PathVariable("IATACODE") String IATACODE ) {
		log.info("Fetching specific airport details.");
		try {
			return ResponseEntity.ok(airportService.getAirport(IATACODE));
		}
		catch(AirportNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMes("404"));
		}

	}

	@PutMapping("airport/{IATACODE}")
	public ResponseEntity <?> updateAirportDetails(@PathVariable ("IATACODE") String IATACODE, @RequestBody Airport airport) {
		log.info("updating specific airport details.");
		try {
			return ResponseEntity.ok(airportService.updateAirport(IATACODE,airport));
		}
		catch (AirportNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMes("404"));
		}
	}
	
	
	@DeleteMapping("airport/{IATACODE}")
	public ResponseEntity<?> deleteAirportDetails(@PathVariable("IATACODE") String IATACODE) {
		log.info("deleting specific airport details.");
		try {
			return ResponseEntity.ok(airportService.deleteAirport(IATACODE));
		}
		catch (AirportNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMes("404"));
		}
		
	}
}