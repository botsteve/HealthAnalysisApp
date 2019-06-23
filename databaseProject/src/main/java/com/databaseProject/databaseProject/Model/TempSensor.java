package com.databaseProject.databaseProject.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TempSensor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private double tempValue;
    private LocalDateTime timeValue;

    @ManyToOne(fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public TempSensor() {
    }

    public TempSensor(double tempValue, LocalDateTime timeValue, User user) {
        this.tempValue = tempValue;
        this.timeValue = timeValue;
        this.user = user;
    }

    public TempSensor(double tempValue, LocalDateTime timeValue) {
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

    public LocalDateTime getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(LocalDateTime timeValue) {
        this.timeValue = timeValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
