package com.databaseProject.databaseProject.Dto;

import java.time.LocalDateTime;

public class TempSensorDto {

    private double tempValue;
    private LocalDateTime timeValue;

    public TempSensorDto() {
    }

    public TempSensorDto(double tempValue, LocalDateTime timeValue) {
        this.tempValue = tempValue;
        this.timeValue = timeValue;
    }

    public double getTempValue() {
        return tempValue;
    }

    public void setTempValue(double tempValue) {
        this.tempValue = tempValue;
    }

    public LocalDateTime getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(LocalDateTime timeValue) {
        this.timeValue = timeValue;
    }

}
