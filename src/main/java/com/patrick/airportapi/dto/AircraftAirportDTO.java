package com.patrick.airportapi.dto;

import java.util.List;

public class AircraftAirportsDTO {

    private Long aircraftId;
    private String type;
    private String airlineName;
    private List<AirportSummaryDTO> airports;

    public AircraftAirportsDTO() {
    }

    public AircraftAirportsDTO(Long aircraftId, String type, String airlineName, List<AirportSummaryDTO> airports) {
        this.aircraftId = aircraftId;
        this.type = type;
        this.airlineName = airlineName;
        this.airports = airports;
    }

    public Long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public List<AirportSummaryDTO> getAirports() {
        return airports;
    }

    public void setAirports(List<AirportSummaryDTO> airports) {
        this.airports = airports;
    }
}
