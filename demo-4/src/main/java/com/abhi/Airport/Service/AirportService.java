package com.abhi.Airport.Service;

import java.util.List;

import com.abhi.Airport.Entity.Airport;

public interface AirportService {
	public String createAirport(Airport airport);
	public String updateAirport(Airport airport);
	public String deleteAirport(String airportIATACODE);
	public Airport getAirport(String airportIATACODE);
	public List<Airport> getAllAirports();
}