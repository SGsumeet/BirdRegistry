package com.example.myproject.services;

import com.example.myproject.model.Bird;
import com.example.myproject.repository.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BirdService {
    @Autowired
    private BirdRepository birdRepository;

    // Create a new bird
    public Bird createBird(Bird bird) {
        bird.setAdded(dateFormatter(Date.from(Instant.now())));
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

    private String dateFormatter(Date addDate){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = formatter.format(addDate);
        return formattedDate;
    }
}