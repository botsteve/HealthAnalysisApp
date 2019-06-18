package com.databaseProject.databaseProject.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
public class TempSensor {
    @Id
    @GeneratedValue
    private int id;
    private double tempValue;
    private LocalTime timeValue;

    public TempSensor(double tempValue, LocalTime timeValue) {
        this.tempValue = tempValue;
        this.timeValue = timeValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
