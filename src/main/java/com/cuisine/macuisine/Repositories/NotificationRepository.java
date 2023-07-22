package com.cuisine.macuisine.Repositories;

import com.cuisine.macuisine.Entites.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
