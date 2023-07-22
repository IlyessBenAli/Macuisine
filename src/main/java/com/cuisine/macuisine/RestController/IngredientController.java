package com.cuisine.macuisine.RestController;

import com.cuisine.macuisine.Entites.Ingredient;
import com.cuisine.macuisine.Repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Transactional
@RequestMapping(value = "/api/ingredients", produces = MediaType.APPLICATION_JSON_VALUE)
public class IngredientController {
    @Autowired
    IngredientRepository ingredientRepository;
    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        try {
            List<Ingredient> ingredients = ingredientRepository.findAll();
            if (ingredients.isEmpty()) {
                // Return an empty list instead of HttpStatus.NO_CONTENT
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
            }
            return new ResponseEntity<>(ingredients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Ingredient> createTutorial(@RequestBody Ingredient ingredient) {
        try {
            ingredientRepository.save(ingredient);
            return new ResponseEntity<>(ingredient, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @RequestBody Ingredient updatedIngredient) {
        Ingredient existingIngredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ingredient with ID " + id + " not found"));

        existingIngredient.setName(updatedIngredient.getName());
        existingIngredient.setDescription(updatedIngredient.getDescription());


        ingredientRepository.save(existingIngredient);
        return new ResponseEntity<>(existingIngredient, HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteIngredient(@PathVariable Long id) {
        try {
            ingredientRepository.deleteById(id);

            // Return a success message in the response body
            Map<String, String> response = new HashMap<>();
            response.put("message", "Ingredient with ID " + id + " deleted successfully.");

            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            // If an exception occurs, return an error message
            Map<String, String> response = new HashMap<>();
            response.put("message", "Failed to delete Ingredient with ID " + id);
            response.put("error", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ingredient with ID " + id + " not found"));
    }

}
