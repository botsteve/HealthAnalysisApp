package com.databaseProject.databaseProject.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;

public class TempSensorDto {

    private double tempValue;
    private LocalTime timeValue;

    public TempSensorDto(double tempValue, LocalTime timeValue) {
        this.tempValue = tempValue;
        this.timeValue = timeValue;
    }

    public double getTempValue() {
        return tempValue;
    }

    public void setTempValue(double tempValue) {
        this.tempValue = tempValue;
    }

    public LocalTime getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(LocalTime timeValue) {
        this.timeValue = timeValue;
    }
}
