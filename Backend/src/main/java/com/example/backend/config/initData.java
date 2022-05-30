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
        teamService.saveTeam(team);
        teamService.saveTeam(team2);
        teamService.saveTeam(team3);

        //HOLD 1
        Biker biker = new Biker();
        biker.setBikerName("PICHON Laurent");
        biker.setTeam(team);
        bikerService.saveBiker(biker);

        Biker biker2 = new Biker();
        biker2.setBikerName("QUINTANA Nairo");
        biker2.setTeam(team);
        bikerService.saveBiker(biker2);

        Biker biker3 = new Biker();
        biker3.setBikerName("BARGUIL Warren");
        biker3.setTeam(team);
        bikerService.saveBiker(biker3);

        Biker biker4 = new Biker();
        biker4.setBikerName("BOUHANNI Nacer");
        biker4.setTeam(team);
        bikerService.saveBiker(biker4);

        //HOLD 2

        Biker biker5 = new Biker();
        biker5.setBikerName("VAN MOER Brent");
        biker5.setTeam(team2);
        bikerService.saveBiker(biker5);

        Biker biker6 = new Biker();
        biker6.setBikerName("WELLENS Tim");
        biker6.setTeam(team2);
        bikerService.saveBiker(biker6);

        Biker biker7 = new Biker();
        biker7.setBikerName("GILBERT Philippe");
        biker7.setTeam(team2);
        bikerService.saveBiker(biker7);

        Biker biker8 = new Biker();
        biker8.setBikerName("EWAN Caleb");
        biker8.setTeam(team2);
        bikerService.saveBiker(biker8);



    }
}
