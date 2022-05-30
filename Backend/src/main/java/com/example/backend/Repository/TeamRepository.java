package com.example.backend.Repository;

import com.example.backend.Model.Biker;
import com.example.backend.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    public List<Biker> findAllByTeamName(String teamName);
}
