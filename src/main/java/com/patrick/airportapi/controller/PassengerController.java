package com.patrick.airportapi.controller;

import com.patrick.airportapi.dto.PassengerAircraftDTO;
import com.patrick.airportapi.entity.Passenger;
import com.patrick.airportapi.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    // pagination + sorting
    // GET /api/passengers?page=0&size=5&sort=lastName,asc
    @GetMapping
    public Page<Passenger> getAllPassengers(Pageable pageable) {
        return passengerService.getAllPassengers(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) {
        return ResponseEntity.ok(passengerService.getPassengerById(id));
    }

    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        return ResponseEntity.ok(passengerService.createPassenger(passenger));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        return ResponseEntity.ok(passengerService.updatePassenger(id, passenger));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }

    // Q2: aircraft per passenger
    @GetMapping("/aircraft-summary")
    public List<PassengerAircraftDTO> getPassengersWithAircraft() {
        return passengerService.getPassengersWithAircraft();
    }
}
