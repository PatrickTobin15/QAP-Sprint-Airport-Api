package com.patrick.airportapi.repository;

import com.patrick.airportapi.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
