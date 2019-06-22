package com.databaseProject.databaseProject.Dto;


public class EMGDto {

    private double voltageValue;
    private long timeValue;

    public EMGDto() {
    }

    public EMGDto(double voltageValue, long timeValue) {
        this.voltageValue = voltageValue;
        this.timeValue = timeValue;
    }

    public double getVoltageValue() {
        return voltageValue;
    }

    public void setVoltageValue(double voltageValue) {
        this.voltageValue = voltageValue;
    }

    public long getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(long timeValue) {
        this.timeValue = timeValue;
    }


}
