package com.databaseProject.databaseProject.Dto;

import com.databaseProject.databaseProject.Model.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;


public class GPSDto {
    private double latitude;
    private double longitude;
    private double altitude;
    private LocalDateTime timeValue;


    public GPSDto() {
    }

    public GPSDto(double latitude, double longitude, double altitude, LocalDateTime timeValue) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timeValue = timeValue;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public LocalDateTime getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(LocalDateTime timeValue) {
        this.timeValue = timeValue;
    }
}
