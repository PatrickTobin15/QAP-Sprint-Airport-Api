package com.patrick.airportapi.dto;

public class UsedAirportDTO {

    private Long airportId;
    private String name;
    private String code;
    private String cityName;

    public UsedAirportDTO() {
    }

    public UsedAirportDTO(Long airportId, String name, String code, String cityName) {
        this.airportId = airportId;
        this.name = name;
        this.code = code;
        this.cityName = cityName;
    }

    public Long getAirportId() {
        return airportId;
    }

    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
