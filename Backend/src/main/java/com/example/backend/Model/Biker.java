package com.example.backend.Model;

import javax.persistence.*;

@Entity
public class Biker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bikerId;
    private String bikerName;
    private String time;
    private String mountainPoints;
    private String SprintPoints;
    private String teamName;

    public String getTeamName() {
        return teamName;
    }


    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getBikerId() {
        return bikerId;
    }

    public void setBikerId(int bikerId) {
        this.bikerId = bikerId;
    }

    public String getName() {
        return bikerName;
    }

    public void setName(String bikerName) {
        this.bikerName = bikerName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMountainPoints() {
        return mountainPoints;
    }

    public void setMountainPoints(String mountainPoints) {
        this.mountainPoints = mountainPoints;
    }

    public String getSprintPoints() {
        return SprintPoints;
    }

    public void setSprintPoints(String sprintPoints) {
        SprintPoints = sprintPoints;
    }

}
