package com.patrick.airportapi.repository;

import com.patrick.airportapi.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    // airports for one city
    List<Airport> findByCity_Id(Long cityId);
}
