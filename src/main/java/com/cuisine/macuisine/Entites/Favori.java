package com.cuisine.macuisine.Entites;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Favori ")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Favori  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Utilisateur qui a ajouté la recette en favori

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recette recette; // Recette ajoutée en favori

}
