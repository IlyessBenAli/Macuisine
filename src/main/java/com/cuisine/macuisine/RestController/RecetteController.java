package com.cuisine.macuisine.RestController;
import java.util.*;

import com.cuisine.macuisine.Entites.Recette;
import com.cuisine.macuisine.Repositories.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Transactional
@RequestMapping(value = "/api/recettes", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecetteController {
    @Autowired
    RecetteRepository recetteRepository;
    @GetMapping
    public ResponseEntity<List<Recette>> getAllRecettes() {
        try {
            List<Recette> recettes = recetteRepository.findAll();
            if (recettes.isEmpty()) {
                // Return an empty list instead of HttpStatus.NO_CONTENT
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
            }
            return new ResponseEntity<>(recettes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Recette> createTutorial(@RequestBody Recette recette) {
        try {
            recetteRepository.save(recette);
            return new ResponseEntity<>(recette, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Recette> updateRecette(@PathVariable Long id, @RequestBody Recette updatedRecette) {
        Recette existingRecette = recetteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recette with ID " + id + " not found"));

        existingRecette.setTitle(updatedRecette.getTitle());
        existingRecette.setDescription(updatedRecette.getDescription());
        existingRecette.setRating(updatedRecette.getRating());
        existingRecette.setImages(updatedRecette.getImages());
        existingRecette.setFavorites(updatedRecette.getFavorites());
        existingRecette.setCatgeorie(updatedRecette.getCatgeorie());

        recetteRepository.save(existingRecette);
        return new ResponseEntity<>(existingRecette, HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteRecette(@PathVariable Long id) {
        try {
            recetteRepository.deleteById(id);

            // Return a success message in the response body
            Map<String, String> response = new HashMap<>();
            response.put("message", "Recette with ID " + id + " deleted successfully.");

            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            // If an exception occurs, return an error message
            Map<String, String> response = new HashMap<>();
            response.put("message", "Failed to delete Recette with ID " + id);
            response.put("error", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public Recette getRecetteById(@PathVariable Long id) {
        return recetteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recette with ID " + id + " not found"));
    }

}
