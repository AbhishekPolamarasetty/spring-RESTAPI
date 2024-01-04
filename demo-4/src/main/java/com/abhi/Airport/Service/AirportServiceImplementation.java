package com.abhi.Airport.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.Airport.Entity.Airport;
import com.abhi.Airport.Exception.AirportAlreadyExists;
import com.abhi.Airport.Exception.AirportNotFoundException;
//import com.abhi.Airport.Exception.ResourceConflictException;
import com.abhi.Airport.Repository.AirportRepository;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class AirportServiceImplementation implements AirportService{
	
//	private static final Logger logger = LoggerFactory.getLogger(AirportServiceImplementation.class);
	
	@Autowired
	private AirportRepository airportRepository;

	
	@Override
	public List <Airport> getAllAirports(){
		log.info("Fetching all airports from the repository.");
		return airportRepository.findAll();
	}
	
	@Override
	public String createAirport(Airport airport) {
	  
	        if (!airportRepository.existsById(airport.getIATACODE())) {
	        	log.info("Creating airport...");
		        airportRepository.save(airport);
		        return "Success";
	        }

	        else {
	        	 log.error("Airport is already Exists");
	             throw new AirportAlreadyExists("Airport with IATA code already exists");
	        }
	} 

	
	@Override
	public Airport getAirport(String IATACODE) {
	
			if (!airportRepository.findById(IATACODE).isEmpty()) {
				log.info("Fetching specific airport from the repository.");
				return airportRepository.findById(IATACODE).get();
		    }
			else {
		        log.error("Requested airport does not exist for IATACODE: {}", IATACODE);
		        throw new AirportNotFoundException("Requested airport does not exist");
			}
		   
	    
	}
	
	@Override
	public String updateAirport(String IATACode, Airport updatedAirport) {
	    Optional <Airport> optionalExistingAirport = airportRepository.findById(IATACode);

	    if (optionalExistingAirport.isPresent()) {
	    	  log.info("Updating specific airport from the repository.");
	        Airport existingAirport = optionalExistingAirport.get();
	        
	        existingAirport.setAirportName(updatedAirport.getAirportName());
	        existingAirport.setCityName(updatedAirport.getCityName());
	      
	        airportRepository.save(existingAirport);
	        return "Airport details updated successfully";
	    } else {
	    	log.error("Airport with IATA code does not exist");
	        throw new AirportNotFoundException("Airport with IATA code does not exist");
	    }
	}

	@Override
	public String deleteAirport(String airportIATACODE) {
		
	        if (airportRepository.existsById(airportIATACODE)) {
	            log.info("Deleting specific airport from the repository.");
	            airportRepository.deleteById(airportIATACODE);
	            return "Airport deleted successfully";
	        } 
	        else {
	            log.error("Airport with IATA code does not exist");
	            throw new AirportNotFoundException("Airport with IATA code does not exist");
	        }
	 
	}	
}