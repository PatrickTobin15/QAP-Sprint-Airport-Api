package com.patrick.airportapi.repository;

import com.patrick.airportapi.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    // findAll(Pageable) inherited - used for pagination
}
