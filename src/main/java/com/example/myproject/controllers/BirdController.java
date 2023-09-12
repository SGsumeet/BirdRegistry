package com.example.myproject.controllers;

import com.example.myproject.services.BirdService;
import com.example.myproject.model.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/birds")
public class BirdController {
    @Autowired
    private BirdService birdService;

    // Create a new bird
    @PostMapping
    public Bird createBird(@RequestBody Bird bird) {
        return birdService.createBird(bird);
    }

    // Get all birds
    @GetMapping
    public List<Bird> getAllBirds() {
        return birdService.getAllBirds();
    }

    // Get bird by ID
    @GetMapping("/{id}")
    public Optional<Bird> getBirdById(@PathVariable Long id) {
        return birdService.getBirdById(id);
    }

    // Update bird by ID
    @PutMapping("/{id}")
    public Bird updateBird(@PathVariable Long id, @RequestBody Bird birdDetails) {
        return birdService.updateBird(id, birdDetails);
    }

    // Delete all birds
    @DeleteMapping
    public String deleteAllBirds() {
        birdService.deleteAllBirds();
        return "All birds have been deleted successfully.";
    }

    // Delete bird by ID
    @DeleteMapping("/{id}")
    public void deleteBird(@PathVariable Long id) {
        birdService.deleteBird(id);
    }
}