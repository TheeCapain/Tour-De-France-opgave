package com.example.backend.Repository;

import com.example.backend.Model.Biker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikerRepository extends JpaRepository<Biker, Integer> {
}
