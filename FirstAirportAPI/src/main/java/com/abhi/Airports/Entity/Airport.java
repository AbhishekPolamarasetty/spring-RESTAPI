package com.abhi.Airports.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Airport {
    @Id
    @Column(name = "IATA_CODE") // Ensure consistency with the database column name
    @JsonProperty("IATA_code") // JSON property name
    private String IATACode;

    @JsonProperty("Airport_name")
    private String airportName;

    @JsonProperty("city_name")
    private String cityName;

    public Airport () {
    	
    }
    // Constructor
    public Airport(String IATACode, String airportName, String cityName) {
        this.IATACode = IATACode;
        this.airportName = airportName;
        this.cityName = cityName;
    }

}
