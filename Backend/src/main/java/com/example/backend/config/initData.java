package com.example.backend.config;

import com.example.backend.Model.Biker;
import com.example.backend.Model.Team;
import com.example.backend.Service.BikerService;
import com.example.backend.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class initData implements CommandLineRunner {

    @Autowired
    BikerService bikerService;

    @Autowired
    TeamService teamService;

    @Override
    public void run(String... args) throws Exception {

        //Tager udgangspunkt i 3 hold

        Team team = new Team();
        team.setTeamName("Alpecin-Deceuninnck");
        Team team2 = new Team();
        team2.setTeamName("Trek - Segafredo");
        Team team3= new Team();
        team3.setTeamName("BORA - hansgrohe");

        teamService.saveTeam(team);
        teamService.saveTeam(team2);
        teamService.saveTeam(team3);




        Biker biker = new Biker();
        biker.setMountainPoints("23");
        biker.setName("Johnny Depp");
        biker.setTime("20 timer");
        biker.setTeamName(team.getTeamName());
        bikerService.saveBiker(biker);

        Biker biker2 = new Biker();
        biker2.setMountainPoints("23");
        biker2.setName("Johnny Depp");
        biker2.setTime("20");
        bikerService.saveBiker(biker2);

    }
}
