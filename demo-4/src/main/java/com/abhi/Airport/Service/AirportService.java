package com.abhi.Airport.Service;

import java.util.List;

import com.abhi.Airport.Entity.Airport;
import com.abhi.Airport.Exception.AirportAlreadyExists;
import com.abhi.Airport.Exception.AirportNotFoundException;

public interface AirportService {
	public String createAirport(Airport airport) throws AirportAlreadyExists;
	public String updateAirport(Airport airport);
	public String deleteAirport(String airportIATACODE)throws AirportNotFoundException;
	public Airport getAirport(String airportIATACODE) throws AirportNotFoundException;
	public List<Airport> getAllAirports();
}
