package com.example.backend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamID;
    @NotNull
    private String teamName;

    @OneToMany
    @JoinColumn(name = "team_id")
    private List<Biker> teamMembers;

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public List<Biker> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Biker> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public void addTeamMember(Biker biker){
        this.teamMembers.add(biker);

    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
