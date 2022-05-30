package com.example.backend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Biker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bikerId;
    private String bikerName;
    private int bikerTime;

    @JsonBackReference
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="teamid")
    private Team team;

    public int getBikerTime() {
        return bikerTime;
    }

    public void setBikerTime(int bikerTime) {
        this.bikerTime = bikerTime;
    }

    public String getBikerName() {
        return bikerName;
    }

    public void setBikerName(String bikerName) {
        this.bikerName = bikerName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getBikerId() {
        return bikerId;
    }

    public void setBikerId(int bikerId) {
        this.bikerId = bikerId;
    }

}
