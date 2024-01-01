package com.abhi.Airport.Controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.Airport.Entity.Airport;
import com.abhi.Airport.Service.AirportService;

//import ch.qos.logback.classic.Logger;

//import ch.qos.logback.classic.Logger;

//import ch.qos.logback.classic.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		logger.debug("Fetching all airport details - entering the method.");
		return airportService.getAllAirports();
	}
	
	@PostMapping
	public String createAirportDetails(@RequestBody Airport airport) {
		logger.info("creating all airport details.");
		airportService.createAirport(airport);
		return "Airport created successfully";
	}
	
	@GetMapping("{IATACODE}")
	public Airport getAirportDetails(@PathVariable("IATACODE") String IATACODE ) {
		logger.info("Fetching specific airport details.");
		return airportService.getAirport(IATACODE);
	}
    
	@PutMapping("{IATACODE}")
	public String updateAirportDetails(@RequestBody Airport airport) {
		logger.info("updating specific airport details.");
		airportService.updateAirport(airport);
		return "Airport updated successfully";
	}
	@DeleteMapping("{IATACODE}")
	public String deleteAirportDetails(@PathVariable("IATACODE") String IATACODE) {
		logger.info("deleting specific airport details.");
		airportService.deleteAirport(IATACODE);
		return "Airport deleted successfully";
	}
}