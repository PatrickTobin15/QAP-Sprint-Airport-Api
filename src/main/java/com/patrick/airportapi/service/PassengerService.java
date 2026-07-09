package com.patrick.airportapi.service;

import com.patrick.airportapi.dto.AircraftSummaryDTO;
import com.patrick.airportapi.dto.PassengerAircraftDTO;
import com.patrick.airportapi.entity.Passenger;
import com.patrick.airportapi.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    // pagination + sorting
    public Page<Passenger> getAllPassengers(Pageable pageable) {
        return passengerRepository.findAll(pageable);
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found with id " + id));
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger updatedPassenger) {
        Passenger passenger = getPassengerById(id);
        passenger.setFirstName(updatedPassenger.getFirstName());
        passenger.setLastName(updatedPassenger.getLastName());
        passenger.setPhoneNumber(updatedPassenger.getPhoneNumber());
        passenger.setCity(updatedPassenger.getCity());
        passenger.setAircraft(updatedPassenger.getAircraft());
        return passengerRepository.save(passenger);
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    // Q2: aircraft per passenger
    public List<PassengerAircraftDTO> getPassengersWithAircraft() {
        return passengerRepository.findAll().stream()
                .map(passenger -> {
                    List<AircraftSummaryDTO> aircraftDTOs = passenger.getAircraft().stream()
                            .map(a -> new AircraftSummaryDTO(a.getId(), a.getType(), a.getAirlineName()))
                            .collect(Collectors.toList());
                    return new PassengerAircraftDTO(
                            passenger.getId(),
                            passenger.getFirstName(),
                            passenger.getLastName(),
                            aircraftDTOs
                    );
                })
                .collect(Collectors.toList());
    }
}
