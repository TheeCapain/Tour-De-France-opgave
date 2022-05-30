package com.example.backend.Service;

import com.example.backend.Model.Biker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
@Import(BikerService.class)
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