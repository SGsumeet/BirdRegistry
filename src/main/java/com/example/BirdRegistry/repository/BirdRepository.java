package com.example.BirdRegistry.repository;

import com.example.BirdRegistry.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdRepository extends JpaRepository<Bird, Long> {
}