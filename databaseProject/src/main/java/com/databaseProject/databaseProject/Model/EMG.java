package com.databaseProject.databaseProject.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EMG {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private double voltageValue;
    private LocalDateTime timeValue;

    @ManyToOne(fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public EMG() {
    }

    public EMG(double voltageValue, LocalDateTime timeValue, User user) {
        this.voltageValue = voltageValue;
        this.timeValue = timeValue;
        this.user = user;
    }

    public EMG(double voltageValue, LocalDateTime timeValue) {
        this.voltageValue = voltageValue;
        this.timeValue = timeValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
