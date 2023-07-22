package com.cuisine.macuisine.Repositories;

import com.cuisine.macuisine.Entites.Post;
import com.cuisine.macuisine.Entites.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteRepository extends JpaRepository<Recette, Long> {
}

