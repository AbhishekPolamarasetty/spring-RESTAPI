package com.abhi.Airports.Service;

import com.abhi.Airports.Entity.Airport;
import com.abhi.Airports.Exception.AirportNotFoundException;
import com.abhi.Airports.Repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import java.util.List;
//import java.util.Optional;

@Service
@Transactional
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports() {
        try {
            return airportRepository.findAll();
        } catch (DataAccessException ex) {
            // Log the exception or handle it accordingly
            // For example, throw a custom exception or return a default value
            throw new RuntimeException("Error occurred while fetching airports", ex);
        }
    }

    public Airport createAirport(Airport airport) {
        try {
            return airportRepository.save(airport);
        } catch (DataAccessException ex) {
            // Log the exception or handle it accordingly
            throw new RuntimeException("Error occurred while creating airport", ex);
        }
    }

    public Airport getAirportById(String airportId) {
    	if(airportRepository.findById(airportId).isEmpty())
    		throw new AirportNotFoundException("Requested Airport does not exist");
    	return airportRepository.findById(airportId).get();
//        try {
//            Optional<Airport> optionalAirport = airportRepository.findById(airportId);
//            return optionalAirport.orElse(null);
//        } catch (DataAccessException ex) {
//            throw new RuntimeException("Error occurred while fetching airport by ID", ex);
//        }
    }

    public Airport updateAirport(String airportId, Airport updatedAirport) {
        try {
            Optional<Airport> optionalAirport = airportRepository.findById(airportId);
            if (optionalAirport.isPresent()) {
                Airport existingAirport = optionalAirport.get();
                existingAirport.setAirportName(updatedAirport.getAirportName());
                existingAirport.setCityName(updatedAirport.getCityName());
                return airportRepository.save(existingAirport);
            }
            return null;
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error occurred while updating airport", ex);
        }
    }

    public void deleteAirport(String airportId) {
        try {
            airportRepository.deleteById(airportId);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error occurred while deleting airport", ex);
        }
    }
}