package com.cuisine.macuisine.Services;

import com.cuisine.macuisine.Entites.Comment;
import com.cuisine.macuisine.Entites.Comment;
import com.cuisine.macuisine.Entites.Post;
import com.cuisine.macuisine.Entites.User;
import com.cuisine.macuisine.Repositories.CommentRepository;
import com.cuisine.macuisine.Repositories.PostRepository;
import com.cuisine.macuisine.exceptions.ErrorStrings;
import com.cuisine.macuisine.exceptions.MyInternalServerErrorException;
import com.cuisine.macuisine.exceptions.MyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentImpl  implements IComment{

    @Autowired
    CommentRepository commentRepository ;
    @Autowired
    PostRepository postRepository ;
    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }



    @Override
    public void saveComment(Comment comment,Long idpost) {
        try {
            Post post=postRepository.findById(idpost).get();
            comment.setPost(post);
            commentRepository.save(comment);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.CLINT_NOT_FOUND));
    }

    public void deleteComment(Long id) {
        try {
            commentRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    public Comment updateComment(Long id, Comment comment) {
        Comment commentdb =  commentRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.Comment_NOT_FOUND));
        try {
            // Mise à jour des propriétés du commentaire
            commentdb.setContent(comment.getContent());
            commentdb.setDateComment(comment.getDateComment());
            commentdb.setPost(comment.getPost());
            commentdb.setUser(comment. getUser());
            commentRepository.save(commentdb);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
        return commentdb;
    }

}
