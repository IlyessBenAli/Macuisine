package com.cuisine.macuisine.Entites;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Notification")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content; // Contenu de la notification
    private boolean read; // Statut de lecture (lu ou non lu)

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")

    private
    Date createdAt; // Date et heure de la notification
}
