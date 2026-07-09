package com.patrick.airportapi.controller;

import com.patrick.airportapi.dto.UsedAirportDTO;
import com.patrick.airportapi.entity.Airport;
import com.patrick.airportapi.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        return ResponseEntity.ok(airportService.getAirportById(id));
    }

    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        return ResponseEntity.ok(airportService.createAirport(airport));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @RequestBody Airport airport) {
        return ResponseEntity.ok(airportService.updateAirport(id, airport));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }

    // Q4: airports used by passengers
    @GetMapping("/used-by-passengers")
    public List<UsedAirportDTO> getAirportsUsedByPassengers() {
        return airportService.getAirportsUsedByPassengers();
    }
}
