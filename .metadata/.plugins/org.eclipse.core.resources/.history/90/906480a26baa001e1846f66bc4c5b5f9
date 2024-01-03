package com.abhi.Airport.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Airport_details")
public class Airport {
	
	@Id
	@JsonProperty("IATA_code")
	private String IATACODE;
	
	@JsonProperty("airport_name")
	private String airportName;
	
	@JsonProperty("city_name")
	private String cityName;
	
	public Airport() {
		
	}
	
	public Airport(String IATACODE,String airportName,String cityName) {
		this.IATACODE = IATACODE;
		this.airportName = airportName;
		this.cityName = cityName;
	}
}