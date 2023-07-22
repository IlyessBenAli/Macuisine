package com.cuisine.macuisine.Repositories;
import com.cuisine.macuisine.Entites.Comment;
import com.cuisine.macuisine.Entites.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
