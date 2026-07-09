package com.patrick.airportapi.service;

import com.patrick.airportapi.dto.AirportSummaryDTO;
import com.patrick.airportapi.dto.CityAirportsDTO;
import com.patrick.airportapi.entity.Airport;
import com.patrick.airportapi.entity.City;
import com.patrick.airportapi.repository.AirportRepository;
import com.patrick.airportapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final AirportRepository airportRepository;

    @Autowired
    public CityService(CityRepository cityRepository, AirportRepository airportRepository) {
        this.cityRepository = cityRepository;
        this.airportRepository = airportRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id " + id));
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City updatedCity) {
        City city = getCityById(id);
        city.setName(updatedCity.getName());
        city.setState(updatedCity.getState());
        city.setPopulation(updatedCity.getPopulation());
        return cityRepository.save(city);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    // Q1: airports per city
    public List<CityAirportsDTO> getCitiesWithAirports() {
        return cityRepository.findAll().stream()
                .map(city -> {
                    List<Airport> airports = airportRepository.findByCity_Id(city.getId());
                    List<AirportSummaryDTO> airportDTOs = airports.stream()
                            .map(a -> new AirportSummaryDTO(a.getId(), a.getName(), a.getCode()))
                            .collect(Collectors.toList());
                    return new CityAirportsDTO(city.getId(), city.getName(), airportDTOs);
                })
                .collect(Collectors.toList());
    }
}
