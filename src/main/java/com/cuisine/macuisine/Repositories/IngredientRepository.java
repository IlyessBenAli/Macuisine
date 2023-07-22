package com.cuisine.macuisine.Repositories;

import com.cuisine.macuisine.Entites.Ingredient;
import com.cuisine.macuisine.Entites.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
