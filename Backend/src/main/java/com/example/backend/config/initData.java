package com.example.backend.config;

import com.example.backend.Model.Biker;
import com.example.backend.Service.BikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class initData implements CommandLineRunner {

    @Autowired
    BikerService bikerService;

    @Override
    public void run(String... args) throws Exception {
        Biker biker = new Biker();
        biker.setMountainPoints("23");
        biker.setName("Johnny Depp");
        biker.setTime("20 timer");
        biker.setTeamName("Hold test");
        bikerService.saveBiker(biker);

        Biker biker2 = new Biker();
        biker2.setMountainPoints("23");
        biker2.setName("Johnny Depp");
        biker2.setTime("20 timer");
        biker2.setTeamName("Hold test");
        bikerService.saveBiker(biker2);

    }
}
