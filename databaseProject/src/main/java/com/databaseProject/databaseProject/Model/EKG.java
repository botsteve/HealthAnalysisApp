package com.databaseProject.databaseProject.Model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class EKG {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private double voltageValue;
    private long timeValue;

    @ManyToOne(fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public EKG() {
    }

    public EKG(double voltageValue, long timeValue, User user) {
        this.voltageValue = voltageValue;
        this.timeValue = timeValue;
        this.user = user;
    }

    public EKG(double voltageValue, long timeValue) {
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
