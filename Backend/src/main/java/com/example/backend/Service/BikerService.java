package com.example.backend.Service;

import com.example.backend.Model.Biker;
import com.example.backend.Repository.BikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikerService {

    @Autowired
    BikerRepository bikerRepository;

    public List<Biker> getAllBikers(){
        return bikerRepository.findAll();
    }

    public Biker saveBiker(Biker biker){
        return bikerRepository.save(biker);
    }

    public Optional<Biker> getBikerByid (int id){
        return bikerRepository.findById(id);
    }

    public Biker updateBiker(Biker biker, int id){
        return bikerRepository.save(biker);
    }

    public void deleteBiker(int id){
        bikerRepository.deleteById(id);
    }

}
