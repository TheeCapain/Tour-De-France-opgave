package com.example.backend.Service;

import com.example.backend.Model.Biker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BikerServiceTest {

    @Autowired
    BikerService bikerService;

    @Autowired
    TeamService teamService;

    @BeforeEach
    void before(){
    }

    @Test
    void saveBiker() {
        Biker biker = new Biker();

        assertNull(bikerService.saveBiker(biker));
    }
}