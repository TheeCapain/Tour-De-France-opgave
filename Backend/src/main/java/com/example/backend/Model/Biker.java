package com.example.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Biker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bikerId;
    private String name;
    private String time;
    private String mountainPoints;
    private String SprintPoints;
    private String teamName;

    public int getBikerId() {
        return bikerId;
    }

    public void setBikerId(int bikerId) {
        this.bikerId = bikerId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
