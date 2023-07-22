package com.cuisine.macuisine.Entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table( name = "Comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", dateComment=" + dateComment +
                ", post=" + post +
                ", user=" + user +
                '}';
    }

    @Column

    private String content;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateComment;


    @ManyToOne
    @JsonIgnoreProperties("comments")
    @JoinColumn(name = "id_post", nullable = false)
    private Post post;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;


}

