package com.example.backend.Service;

import com.example.backend.Model.Biker;
import com.example.backend.Repository.BikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikerService {

    @Autowired
    BikerRepository bikerRepository;

    public Biker saveBiker(Biker biker){
        return bikerRepository.save(biker);

    }

}
