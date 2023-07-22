package com.cuisine.macuisine.Repositories;

import com.cuisine.macuisine.Entites.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
