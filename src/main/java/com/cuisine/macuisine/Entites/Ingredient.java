package com.cuisine.macuisine.Entites;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "Ingredient")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ingredient  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column

    private String name;
    @Column

    private String description;
}
