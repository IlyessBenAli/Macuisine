package com.cuisine.macuisine.Services;

import com.cuisine.macuisine.Entites.Comment;
import com.cuisine.macuisine.Entites.Comment;

import java.util.List;

public interface IComment {
    List<Comment> getAll();

    void saveComment(Comment comment,Long idpost);

    Comment getCommentById(Long id);

    void deleteComment(Long id);

    Comment updateComment(Long id, Comment comment);

}
