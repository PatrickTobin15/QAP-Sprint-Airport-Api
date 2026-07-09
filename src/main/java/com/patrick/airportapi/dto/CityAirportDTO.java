package com.patrick.airportapi.dto;

import java.util.List;

public class CityAirportsDTO {

    private Long cityId;
    private String cityName;
    private List<AirportSummaryDTO> airports;

    public CityAirportsDTO() {
    }

    public CityAirportsDTO(Long cityId, String cityName, List<AirportSummaryDTO> airports) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.airports = airports;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<AirportSummaryDTO> getAirports() {
        return airports;
    }

    public void setAirports(List<AirportSummaryDTO> airports) {
        this.airports = airports;
    }
}
