package com.abhi.Airports.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//
import com.abhi.Airports.Entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {

}
