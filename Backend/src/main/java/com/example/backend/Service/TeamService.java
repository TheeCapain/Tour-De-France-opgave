package com.example.backend.Service;

import com.example.backend.Model.Team;
import com.example.backend.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public Optional<Team> getByID(int id){
        return teamRepository.findById(id);
    }

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }


    public Team saveTeam(Team team){
        return teamRepository.save(team);
    }

    public Optional<Team> getAllFromTeam(int teamID){
        return teamRepository.findById(teamID);
    }
}
