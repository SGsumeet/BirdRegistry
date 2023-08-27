package com.example.myproject.services;

import com.example.myproject.model.Bird;
import com.example.myproject.repository.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirdService {
    @Autowired
    private BirdRepository birdRepository;

    // Create a new user
    public Bird createBird(Bird bird) {
        return birdRepository.save(bird);
    }

    // Get all users
    public List<Bird> getAllBirds() {
        return birdRepository.findAll();
    }

    // Get user by ID
    public Optional<Bird> getBirdById(Long id) {
        return birdRepository.findById(id);
    }

    // Update user
    public Bird updateBird(Long id, Bird birdDetails) {
        Optional<Bird> user = birdRepository.findById(id);
        if (user.isPresent()) {
            Bird existingBird = user.get();
            existingBird.setName(birdDetails.getName());
            existingBird.setFamily(birdDetails.getFamily());
            existingBird.setContinents(birdDetails.getContinents());
            existingBird.setAdded(birdDetails.getAdded());
            existingBird.setVisible(birdDetails.isVisible());

            return birdRepository.save(existingBird);
        }
        return null;
    }

    // Delete all users
    public void deleteAllBirds() {
        birdRepository.deleteAll();
    }

    // Delete user
    public void deleteBird(Long id) {
        birdRepository.deleteById(id);
    }

    // Other business logic related to users
}