package com.example.backend.Service;

import com.example.backend.Model.Biker;
import com.example.backend.Repository.BikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikerService {

    @Autowired
    BikerRepository bikerRepository;

    public List<Biker> getAllBikers() {
        return bikerRepository.findAll();
    }

    public Biker saveBiker(Biker biker) {
        if (biker.getTeam() != null) {
            return bikerRepository.save(biker);
        }
        return null;
    }

    public Optional<Biker> getBikerById(int id) {
            return bikerRepository.findById(id);


    }

    public Biker updateBiker(Biker biker, int id) {
        return bikerRepository.save(biker);
    }

    public void deleteBiker(int id) {
        bikerRepository.deleteById(id);
    }

}
