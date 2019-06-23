package com.databaseProject.databaseProject.Dto;


import java.time.LocalDateTime;

public class EMGDto {

    private double voltageValue;
    private LocalDateTime timeValue;

    public EMGDto() {
    }

    public EMGDto(double voltageValue, LocalDateTime timeValue) {
        this.voltageValue = voltageValue;
        this.timeValue = timeValue;
    }

    public double getVoltageValue() {
        return voltageValue;
    }

    public void setVoltageValue(double voltageValue) {
        this.voltageValue = voltageValue;
    }

    public LocalDateTime getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(LocalDateTime timeValue) {
        this.timeValue = timeValue;
    }


}
