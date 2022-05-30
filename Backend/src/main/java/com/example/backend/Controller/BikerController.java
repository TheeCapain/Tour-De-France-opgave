package com.example.backend.Controller;

import com.example.backend.Model.Biker;
import com.example.backend.Model.Team;
import com.example.backend.Service.BikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("biker")
public class BikerController {

    @Autowired
    private BikerService bikerService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Biker createNewBiker(@RequestBody Biker biker){
        System.out.println(biker.getBikerName());
        return bikerService.saveBiker(biker);
    }

    @GetMapping("/{id}")
    public Optional<Biker> getBikerById(@PathVariable int id){
       return bikerService.getBikerByid(id);
    }
    @GetMapping("/all")
    public List<Biker> getAllBikers(){
        return bikerService.getAllBikers();
    }

    @PutMapping("/update/{id}")
    public Biker updateBiker(@RequestBody Biker biker, @PathVariable int id){
        return bikerService.updateBiker(biker, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBiker(@PathVariable int id){
        bikerService.deleteBiker(id);
    }





}
