package com.abhi.Airport.Repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.abhi.Airport.Entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, String>{
}
