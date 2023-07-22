package com.cuisine.macuisine.Repositories;

import com.cuisine.macuisine.Entites.Favori;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriRepository extends JpaRepository<Favori, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}

