package com.cuisine.macuisine.RestController;

import com.cuisine.macuisine.Entites.Comment;
import com.cuisine.macuisine.Entites.Post;
import com.cuisine.macuisine.Services.IComment;
import com.cuisine.macuisine.Services.IPost;
import com.cuisine.macuisine.exceptions.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Transactional
@RequestMapping(value = "/api/comments", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {

    @Autowired
    IComment commentService;
    @Autowired
    IPost postService;





    @PostMapping(value = "/{idpst}", consumes = "application/json")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment, @RequestHeader HttpHeaders headers, @PathVariable Long idpst) {
        // Access the headers
        String contentType = headers.getFirst(HttpHeaders.CONTENT_TYPE);
        // Enregistrer le commentaire
        commentService.saveComment(comment,idpst);

        return new ResponseEntity<Comment>(comment, HttpStatus.CREATED);
    }




    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAll();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        try {
            Comment updatedComment = commentService.updateComment(id, comment);
            return ResponseEntity.ok(updatedComment);
        } catch (Exception e) {
            // Handle the exception and return an appropriate response
            Comment errorComment = new Comment();
            errorComment.setContent("An error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorComment);
        }
    }



    @DeleteMapping("/{id}")
    public void deleteCommentById(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

}
