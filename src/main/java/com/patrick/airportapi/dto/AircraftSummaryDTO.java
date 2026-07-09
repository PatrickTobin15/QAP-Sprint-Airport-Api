package com.patrick.airportapi.dto;

public class AircraftSummaryDTO {

    private Long id;
    private String type;
    private String airlineName;

    public AircraftSummaryDTO() {
    }

    public AircraftSummaryDTO(Long id, String type, String airlineName) {
        this.id = id;
        this.type = type;
        this.airlineName = airlineName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
