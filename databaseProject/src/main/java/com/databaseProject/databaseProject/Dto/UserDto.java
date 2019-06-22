package com.databaseProject.databaseProject.Dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Integer isLogged;
    private Integer isAdmin;

    private List<TempSensorDto> temperatures = new ArrayList<TempSensorDto>();
    private List<EKGDto> ekgs = new ArrayList<EKGDto>();
    private List<EMGDto> emgs = new ArrayList<EMGDto>();
    private List<GPSDto> gps = new ArrayList<GPSDto>();

    public UserDto() {
        this.isLogged = 0;
        this.isAdmin = 0;
    }

    public UserDto(String email, String firstName, String lastName, String password, Integer isLogged, Integer isAdmin, List<TempSensorDto> temperatures, List<EKGDto> ekgs, List<EMGDto> emgs, List<GPSDto> gps) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isLogged = isLogged;
        this.isAdmin = isAdmin;
        this.temperatures = temperatures;
        this.ekgs = ekgs;
        this.emgs = emgs;
        this.gps = gps;
    }

    public UserDto(String email, String firstName, String lastName, String password, Integer isLogged, Integer isAdmin) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isLogged = isLogged;
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(Integer isLogged) {
        this.isLogged = isLogged;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }


    public List<TempSensorDto> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<TempSensorDto> temperatures) {
        this.temperatures = temperatures;
    }

    public List<EKGDto> getEkgs() {
        return ekgs;
    }

    public void setEkgs(List<EKGDto> ekgs) {
        this.ekgs = ekgs;
    }

    public List<EMGDto> getEmgs() {
        return emgs;
    }

    public void setEmgs(List<EMGDto> emgs) {
        this.emgs = emgs;
    }

    public List<GPSDto> getGps() {
        return gps;
    }

    public void setGps(List<GPSDto> gps) {
        this.gps = gps;
    }

}
