package com.cuisine.macuisine.RestController;
import java.util.*;

import com.cuisine.macuisine.Entites.Note;
import com.cuisine.macuisine.Entites.Recette;
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
@RequestMapping(value = "/api/notes", produces = MediaType.APPLICATION_JSON_VALUE)
public class NoteController {
    @Autowired
    NoteRepository noteRepository;

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        // Enregistrez la note dans la base de données
        try {
            Note savedNote = noteRepository.save(note);
            return new ResponseEntity<>(savedNote, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        // Récupérez la note à partir de l'ID
        Note note = noteRepository.findById(id).orElse(null);
        if (note != null) {
            return new ResponseEntity<>(note, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
