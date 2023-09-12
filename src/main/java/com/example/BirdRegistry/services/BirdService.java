package com.example.BirdRegistry.services;

import com.example.BirdRegistry.model.Bird;
import com.example.BirdRegistry.repository.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirdService {
    @Autowired
    private BirdRepository birdRepository;

    // Create a new bird
    public Bird createBird(Bird bird) {
        return birdRepository.save(bird);
    }

    // Get all birds
    public List<Bird> getAllBirds() {
        return birdRepository.findAll();
    }

    // Get bird by ID
    public Optional<Bird> getBirdById(Long id) {
        return birdRepository.findById(id);
    }

    // Update bird
    public Bird updateBird(Long id, Bird birdDetails) {
        Optional<Bird> bird = birdRepository.findById(id);
        if (bird.isPresent()) {
            Bird existingBird = bird.get();
            existingBird.setName(birdDetails.getName());
            existingBird.setFamily(birdDetails.getFamily());
            existingBird.setContinents(birdDetails.getContinents());
            existingBird.setAdded(birdDetails.getAdded());
            existingBird.setVisible(birdDetails.isVisible());

            return birdRepository.save(existingBird);
        }
        return null;
    }

    // Delete all birds
    public void deleteAllBirds() {
        birdRepository.deleteAll();
    }

    // Delete bird
    public void deleteBird(Long id) {
        birdRepository.deleteById(id);
    }

    // Other business logic related to birds
}