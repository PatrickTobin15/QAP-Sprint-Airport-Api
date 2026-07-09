package com.patrick.airportapi.service;

import com.patrick.airportapi.dto.UsedAirportDTO;
import com.patrick.airportapi.entity.Aircraft;
import com.patrick.airportapi.entity.Airport;
import com.patrick.airportapi.entity.Passenger;
import com.patrick.airportapi.repository.AirportRepository;
import com.patrick.airportapi.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AirportService {

    private final AirportRepository airportRepository;
    private final PassengerRepository passengerRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository, PassengerRepository passengerRepository) {
        this.airportRepository = airportRepository;
        this.passengerRepository = passengerRepository;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found with id " + id));
    }

    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id, Airport updatedAirport) {
        Airport airport = getAirportById(id);
        airport.setName(updatedAirport.getName());
        airport.setCode(updatedAirport.getCode());
        airport.setCity(updatedAirport.getCity());
        return airportRepository.save(airport);
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }

    // Q4: airports used by passengers
    public List<UsedAirportDTO> getAirportsUsedByPassengers() {
        List<Passenger> passengers = passengerRepository.findAll();

        // map by id to remove duplicates
        Map<Long, UsedAirportDTO> usedAirports = new LinkedHashMap<>();

        for (Passenger passenger : passengers) {
            for (Aircraft aircraft : passenger.getAircraft()) {
                for (Airport airport : aircraft.getAirports()) {
                    usedAirports.putIfAbsent(airport.getId(), new UsedAirportDTO(
                            airport.getId(),
                            airport.getName(),
                            airport.getCode(),
                            airport.getCity() != null ? airport.getCity().getName() : null
                    ));
                }
            }
        }

        return usedAirports.values().stream().collect(Collectors.toList());
    }
}
