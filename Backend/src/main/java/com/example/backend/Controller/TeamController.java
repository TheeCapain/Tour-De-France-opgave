package com.example.backend.Controller;

import com.example.backend.Model.Biker;
import com.example.backend.Model.Team;
import com.example.backend.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("{id}")
    public Optional<Team> getTeamById(@PathVariable int id) {
        return teamService.getByID(id);
    }

    @GetMapping("/all")
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/allfrom/{team}")
    public List<Biker> getAllFromTeam(@PathVariable String teamName){ return teamService.getAllFromTeam(teamName);
    }

    @PostMapping("/new")
    public Team createNewTeam(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }
}
