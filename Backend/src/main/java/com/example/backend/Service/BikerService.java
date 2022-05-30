package com.example.backend.Service;

import com.example.backend.Model.Biker;
import com.example.backend.Repository.BikerRepository;
import com.example.backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Biker getBikerById(int id) {
            return bikerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Biker with this ID"));
    }

    public Biker updateBiker(Biker biker, int id) {
        return bikerRepository.save(biker);
    }

    public void deleteBiker(int id) {
        bikerRepository.deleteById(id);
    }

}
