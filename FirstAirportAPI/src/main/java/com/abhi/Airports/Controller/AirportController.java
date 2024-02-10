package com.abhi.Airports.Controller;
import com.abhi.Airports.Service.AirportService;
import com.abhi.Airports.Entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AirportController {

    // Assuming you have a service to handle airport operations
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/airports")
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airports = airportService.getAllAirports();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @PostMapping("/airports")
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        Airport createdAirport = airportService.createAirport(airport);
        return new ResponseEntity<>(createdAirport, HttpStatus.OK);
    }

    @GetMapping("/airports/{airportId}")
    public ResponseEntity<Airport> getAirportById(@PathVariable String airportId) {
        Airport airport = airportService.getAirportById(airportId);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }

    @PutMapping("/airports/{airportId}")
    public String updateAirport(@PathVariable String airportId, @RequestBody Airport airport) {
        Airport updatedAirport = airportService.updateAirport(airportId, airport);
        return "Airport Updated Successfully";
    }

    @DeleteMapping("/airports/{airportId}")
    public String deleteAirport(@PathVariable String airportId) {
        airportService.deleteAirport(airportId);
//        return new ResponseEntity<>(HttpStatus.OK);
        return "Airport deleted Successfully";
    }
}