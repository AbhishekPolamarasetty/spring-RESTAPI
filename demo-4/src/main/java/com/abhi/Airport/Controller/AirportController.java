package com.abhi.Airport.Controller;

import java.util.List;
import org.slf4j.LoggerFactory;
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
import com.abhi.Airport.Exception.AirportNotFoundException;
import com.abhi.Airport.Service.AirportService;

import org.apache.catalina.connector.Response;

//import ch.qos.logback.classic.Logger;

//import ch.qos.logback.classic.Logger;

//import ch.qos.logback.classic.Logger;
import org.slf4j.Logger;

@RestController
@RequestMapping("/airports")
public class AirportController{
	
	private static final Logger logger = LoggerFactory.getLogger(AirportController.class);
	
	AirportService airportService;

	public AirportController(AirportService airportService) {
		this.airportService = airportService;
	}
	
	@GetMapping
	public List<Airport> getAllAirportDetails() {
		logger.info("Fetching all airport details.");
		return airportService.getAllAirports();
	}
	
	@PostMapping
	public ResponseEntity<String> createAirportDetails(@RequestBody Airport airport) {
	    logger.info("creating all airport details.");
	    airportService.createAirport(airport);
	    return ResponseEntity.status(HttpStatus.CREATED).body("Airport created successfully");
	}

	@GetMapping("{IATACODE}")
	public ResponseEntity<?> getAirportDetails(@PathVariable("IATACODE") String IATACODE ) {
		logger.info("Fetching specific airport details.");
		try {
			return ResponseEntity.ok(airportService.getAirport(IATACODE));
		}
		catch(AirportNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMes("404","GetMapping error"));
		}
		
	}
    
	@PutMapping("{IATACODE}")
	public String updateAirportDetails(@RequestBody Airport airport) {
		logger.info("updating specific airport details.");
		airportService.updateAirport(airport);
		return "Airport updated successfully";
	}
	
	@DeleteMapping("{IATACODE}")
	public ResponseEntity<?> deleteAirportDetails(@PathVariable("IATACODE") String IATACODE) {
		logger.info("deleting specific airport details.");
		try {
			return ResponseEntity.ok(airportService.deleteAirport(IATACODE));
		}
		catch (AirportNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMes("404","DeleteMapping error"));
		}
		
	}
}