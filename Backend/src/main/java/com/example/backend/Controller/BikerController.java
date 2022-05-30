package com.example.backend.Controller;

import com.example.backend.Model.Biker;
import com.example.backend.Model.Team;
import com.example.backend.Repository.BikerRepository;
import com.example.backend.Service.BikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("biker")
public class BikerController {

    @Autowired
    private BikerService bikerService;

    @Autowired
    private BikerRepository bikerRepository;

    public Sort.Direction getSortDirection(String direction) {
        if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        } else {
            return Sort.DEFAULT_DIRECTION;
        }
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Biker createNewBiker(@RequestBody Biker biker) {
        System.out.println(biker.getBikerName());
        return bikerService.saveBiker(biker);
    }

    @GetMapping("/{id}")
    public Biker getBikerById(@PathVariable int id) {
        return bikerService.getBikerById(id);
    }


    @GetMapping("/all")
    public List<Biker> getAllBikers() {
        return bikerService.getAllBikers();
    }

    @PutMapping("/update/{id}")
    public Biker updateBiker(@RequestBody Biker biker, @PathVariable int id) {
        return bikerService.updateBiker(biker, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBiker(@PathVariable int id) {
        bikerService.deleteBiker(id);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Biker>> getTeamsAlphabetically(@RequestParam(defaultValue = "bikerTime, asc") String[] sort) {
        for (String s : sort) {
            System.out.println(s);
        }
        List<Sort.Order> orders = new ArrayList<>();

        if (sort[0].contains(",")) {
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
        }

        List<Biker> bikers = bikerRepository.findAll(Sort.by(orders));

        if (bikers.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(bikers, HttpStatus.OK);
    }
}
