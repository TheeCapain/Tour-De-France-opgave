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
        team.setTeamName("Team Arkéa Samsic");
        Team team2 = new Team();
        team2.setTeamName("Lotto Soudal");
        Team team3 = new Team();
        team3.setTeamName("BORA - hansgrohe");


        //HOLD 1
        Biker biker = new Biker();
        biker.setName("PICHON Laurent");
        biker.setTeamName(team.getTeamName());
        bikerService.saveBiker(biker);

        Biker biker2 = new Biker();
        biker2.setName("QUINTANA Nairo");
        biker2.setTeamName(team.getTeamName());
        bikerService.saveBiker(biker2);

        Biker biker3 = new Biker();
        biker3.setName("BARGUIL Warren");
        biker3.setTeamName(team.getTeamName());
        bikerService.saveBiker(biker3);

        Biker biker4 = new Biker();
        biker4.setName("BOUHANNI Nacer");
        biker4.setTeamName(team.getTeamName());
        bikerService.saveBiker(biker4);


        //HOLD 2

        Biker biker5 = new Biker();
        biker5.setName(" VAN MOER Brent");
        biker5.setTeamName(team2.getTeamName());
        bikerService.saveBiker(biker5);

        Biker biker6 = new Biker();
        biker6.setName(" WELLENS Tim");
        biker6.setTeamName(team2.getTeamName());
        bikerService.saveBiker(biker6);

        Biker biker7 = new Biker();
        biker7.setName("GILBERT Philippe");
        biker7.setTeamName(team2.getTeamName());
        bikerService.saveBiker(biker7);

        Biker biker8 = new Biker();
        biker8.setTeamName(team2.getTeamName());
        biker8.setName("EWAN Caleb");
        bikerService.saveBiker(biker8);

        teamService.saveTeam(team);
        teamService.saveTeam(team2);
        teamService.saveTeam(team3);

    }
}
