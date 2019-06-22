package com.databaseProject.databaseProject.Dto;

import com.databaseProject.databaseProject.Model.User;

public class TempSensorDto {

    private double tempValue;
    private long timeValue;

    public TempSensorDto() {
    }

    public TempSensorDto(double tempValue, long timeValue) {
        this.tempValue = tempValue;
        this.timeValue = timeValue;
    }

    public double getTempValue() {
        return tempValue;
    }

    public void setTempValue(double tempValue) {
        this.tempValue = tempValue;
    }

    public long getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(long timeValue) {
        this.timeValue = timeValue;
    }

}
