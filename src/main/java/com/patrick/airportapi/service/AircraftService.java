package com.patrick.airportapi.service;

import com.patrick.airportapi.dto.AircraftAirportsDTO;
import com.patrick.airportapi.dto.AirportSummaryDTO;
import com.patrick.airportapi.entity.Aircraft;
import com.patrick.airportapi.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    public Aircraft getAircraftById(Long id) {
        return aircraftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aircraft not found with id " + id));
    }

    public Aircraft createAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public Aircraft updateAircraft(Long id, Aircraft updatedAircraft) {
        Aircraft aircraft = getAircraftById(id);
        aircraft.setType(updatedAircraft.getType());
        aircraft.setAirlineName(updatedAircraft.getAirlineName());
        aircraft.setNumberOfPassengers(updatedAircraft.getNumberOfPassengers());
        aircraft.setAirports(updatedAircraft.getAirports());
        return aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }

    // Q3: airports per aircraft
    public List<AircraftAirportsDTO> getAircraftWithAirports() {
        return aircraftRepository.findAll().stream()
                .map(aircraft -> {
                    List<AirportSummaryDTO> airportDTOs = aircraft.getAirports().stream()
                            .map(a -> new AirportSummaryDTO(a.getId(), a.getName(), a.getCode()))
                            .collect(Collectors.toList());
                    return new AircraftAirportsDTO(
                            aircraft.getId(),
                            aircraft.getType(),
                            aircraft.getAirlineName(),
                            airportDTOs
                    );
                })
                .collect(Collectors.toList());
    }
}
