package com.abhi.Airport.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.abhi.Airport.Entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String>{
}
