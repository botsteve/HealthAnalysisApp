package com.databaseProject.databaseProject.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Integer isLogged;
    private Integer isAdmin;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.MERGE, orphanRemoval = true)
    private List<TempSensor> temperatures = new ArrayList<TempSensor>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.MERGE, orphanRemoval = true)
    private List<EKG> ekgs = new ArrayList<EKG>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.MERGE, orphanRemoval = true)
    private List<EMG> emgs = new ArrayList<EMG>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.MERGE, orphanRemoval = true)
    private List<GPS> gps = new ArrayList<GPS>();

    public User(int id, String email, String firstName, String lastName, String password, Integer isLogged, Integer isAdmin, List<TempSensor> temperatures, List<EKG> ekgs, List<EMG> emgs, List<GPS> gps) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isLogged = isLogged;
        this.isAdmin = isAdmin;
        this.temperatures = temperatures;
        this.ekgs = ekgs;
        this.emgs = emgs;
        this.gps = gps;
    }

    public User() {
        this.isLogged = 0;
        this.isAdmin = 0;
    }

    public User(String email, String firstName, String lastName, String password, Integer isLogged, Integer isAdmin, List<TempSensor> temperatures, List<EKG> ekgs, List<EMG> emgs, List<GPS> gps) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isLogged = isLogged;
        this.isAdmin = isAdmin;
        this.temperatures = temperatures;
        this.ekgs = ekgs;
        this.emgs = emgs;
        this.gps = gps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(Integer isLogged) {
        this.isLogged = isLogged;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<TempSensor> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<TempSensor> temperatures) {
        this.temperatures = temperatures;
    }

    public List<EKG> getEkgs() {
        return ekgs;
    }

    public void setEkgs(List<EKG> ekgs) {
        this.ekgs = ekgs;
    }

    public List<EMG> getEmgs() {
        return emgs;
    }

    public void setEmgs(List<EMG> emgs) {
        this.emgs = emgs;
    }

    public List<GPS> getGps() {
        return gps;
    }

    public void setGps(List<GPS> gps) {
        this.gps = gps;
    }
}
