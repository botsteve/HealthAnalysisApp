package com.databaseProject.databaseProject.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;

public class EKGDto {
    private double voltageValue;
    private LocalTime timeValue;

    public EKGDto(double voltageValue, LocalTime timeValue) {
        this.voltageValue = voltageValue;
        this.timeValue = timeValue;
    }

    public double getVoltageValue() {
        return voltageValue;
    }

    public void setVoltageValue(double voltageValue) {
        this.voltageValue = voltageValue;
    }

    public LocalTime getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(LocalTime timeValue) {
        this.timeValue = timeValue;
    }
}
