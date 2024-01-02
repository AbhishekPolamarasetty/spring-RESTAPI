package com.abhi.Airport.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.abhi.Airport.Entity.Airport;
import com.abhi.Airport.Exception.AirportNotFoundException;
import com.abhi.Airport.Exception.ResourceConflictException;
import com.abhi.Airport.Repository.AirportRepository;



@Service
public class AirportServiceImplementation implements AirportService{
	
	private static final Logger logger = LoggerFactory.getLogger(AirportServiceImplementation.class);
	
	AirportRepository airportRepository;
	
	public AirportServiceImplementation(AirportRepository airportRepository) {
		this.airportRepository = airportRepository;
	}
	
	
	@Override
	public List<Airport> getAllAirports(){
		logger.info("Fetching all airports from the repository.");
		return airportRepository.findAll();
	}
	
	@Override
	public String createAirport(Airport airport) {
		   if (airportRepository.existsById(airport.getIATACODE())) {
			   logger.error("Airport is already Exists");
	            throw new ResourceConflictException("Airport with IATA code already exists");
	        }

	        // Create the airport as it doesn't exist
	        logger.info("Creating airport...");
	        airportRepository.save(airport);
	        return "Success";
	}
	

	@Override
	public Airport getAirport(String IATACODE) {
		if (airportRepository.findById(IATACODE).isEmpty()) {
	        logger.error("Requested airport does not exist for IATACODE: {}", IATACODE);
	        throw new AirportNotFoundException("Requested airport does not exist");
	    }

	    logger.info("Fetching specific airport from the repository.");
	    return airportRepository.findById(IATACODE).get();
	}
	
	@Override
	public String updateAirport(Airport airport) {
		logger.info("updating specific airport ");
		airportRepository.save(airport);
		return "updated";
	}
	
	@Override
	public String deleteAirport(String airportIATACODE) {
		logger.info("deleting specific airport from the repository.");
		airportRepository.deleteById(airportIATACODE);
		return null;
	}
	
}