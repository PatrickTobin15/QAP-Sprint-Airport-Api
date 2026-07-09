package com.patrick.airportapi.dto;

import java.util.List;

public class PassengerAircraftDTO {

    private Long passengerId;
    private String firstName;
    private String lastName;
    private List<AircraftSummaryDTO> aircraft;

    public PassengerAircraftDTO() {
    }

    public PassengerAircraftDTO(Long passengerId, String firstName, String lastName, List<AircraftSummaryDTO> aircraft) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.aircraft = aircraft;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<AircraftSummaryDTO> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<AircraftSummaryDTO> aircraft) {
        this.aircraft = aircraft;
    }
}
