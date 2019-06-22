package com.databaseProject.databaseProject.Model;

import javax.persistence.*;

@Entity
public class TempSensor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private double tempValue;
    private long timeValue;

    @ManyToOne(fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public TempSensor() {
    }

    public TempSensor(double tempValue, long timeValue, User user) {
        this.tempValue = tempValue;
        this.timeValue = timeValue;
        this.user = user;
    }

    public TempSensor(double tempValue, long timeValue) {
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

    public long getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(long timeValue) {
        this.timeValue = timeValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
