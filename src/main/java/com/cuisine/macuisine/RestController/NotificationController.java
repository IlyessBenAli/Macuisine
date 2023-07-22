package com.cuisine.macuisine.RestController;
import java.util.*;

import com.cuisine.macuisine.Entites.Note;
import com.cuisine.macuisine.Entites.Notification;
import com.cuisine.macuisine.Entites.Recette;
import com.cuisine.macuisine.Repositories.NoteRepository;
import com.cuisine.macuisine.Repositories.NotificationRepository;
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
@RequestMapping(value = "/api/notifications", produces = MediaType.APPLICATION_JSON_VALUE)
public class NotificationController {
    @Autowired
    public NotificationRepository notificationRepository ;
    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        // Enregistrez la notification dans la base de données
        Notification savedNotification = notificationRepository.save(notification);
        return new ResponseEntity<>(savedNotification, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        // Récupérez la notification à partir de l'ID
        Notification notification = notificationRepository.findById(id).orElse(null);
        if (notification != null) {
            return new ResponseEntity<>(notification, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
