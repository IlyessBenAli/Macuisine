package com.cuisine.macuisine.RestController;
import java.util.*;

import com.cuisine.macuisine.Entites.Favori;
import com.cuisine.macuisine.Entites.Note;
import com.cuisine.macuisine.Entites.Recette;
import com.cuisine.macuisine.Repositories.FavoriRepository;
import com.cuisine.macuisine.Repositories.NoteRepository;
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
@RequestMapping(value = "/api/favoris", produces = MediaType.APPLICATION_JSON_VALUE)
public class FavoriController {
    @Autowired
    public FavoriRepository favoriRepository;

    @PostMapping
    public ResponseEntity<Favori> addFavori(@RequestBody Favori favori) {
        // Enregistrez le favori dans la base de données
        Favori savedFavori = favoriRepository.save(favori);
        return new ResponseEntity<>(savedFavori, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFavori(@PathVariable Long id) {
        // Supprimez le favori à partir de l'ID
        favoriRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Ajoutez d'autres méthodes pour récupérer les favoris d'un utilisateur, etc.
    // ...
}








