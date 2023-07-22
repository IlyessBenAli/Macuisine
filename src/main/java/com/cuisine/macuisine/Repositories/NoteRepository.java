package com.cuisine.macuisine.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cuisine.macuisine.Entites.Note;

public interface NoteRepository extends  JpaRepository<Note, Long>{

}
