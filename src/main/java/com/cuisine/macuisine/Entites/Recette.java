package com.cuisine.macuisine.Entites;
import com.cuisine.macuisine.Entites.enums.CategorieRecette;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "Recette")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Recette  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column

    private String title; // Titre de la recette
    @Column


    private String description; // Description de la recette
    @Column

    private double rating;
    @Column

    @ElementCollection
    private List<String> images = new ArrayList<>();
    @Column

    private int favorites;

    @Enumerated
    private  CategorieRecette catgeorie ;

}
