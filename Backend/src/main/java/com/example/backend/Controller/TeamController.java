package com.example.backend.Controller;

import com.example.backend.Model.Team;
import com.example.backend.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/new")
    public Team createNewTeam(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }
}
