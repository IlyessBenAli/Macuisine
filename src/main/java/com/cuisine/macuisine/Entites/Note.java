package com.cuisine.macuisine.Entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "notes")
public class Note implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
    @Column
    private int rating; // La note donnée à la recette (peut être un nombre entier ou décimal)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Utilisateur qui a donné la note.

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recette recette;

}
