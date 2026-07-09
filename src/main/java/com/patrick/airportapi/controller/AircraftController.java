package com.patrick.airportapi.controller;

import com.patrick.airportapi.dto.AircraftAirportsDTO;
import com.patrick.airportapi.entity.Aircraft;
import com.patrick.airportapi.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        return ResponseEntity.ok(aircraftService.getAircraftById(id));
    }

    @PostMapping
    public ResponseEntity<Aircraft> createAircraft(@RequestBody Aircraft aircraft) {
        return ResponseEntity.ok(aircraftService.createAircraft(aircraft));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable Long id, @RequestBody Aircraft aircraft) {
        return ResponseEntity.ok(aircraftService.updateAircraft(id, aircraft));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable Long id) {
        aircraftService.deleteAircraft(id);
        return ResponseEntity.noContent().build();
    }

    // Q3: airports per aircraft
    @GetMapping("/airports-summary")
    public List<AircraftAirportsDTO> getAircraftWithAirports() {
        return aircraftService.getAircraftWithAirports();
    }
}
