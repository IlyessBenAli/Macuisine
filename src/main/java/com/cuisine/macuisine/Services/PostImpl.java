package com.cuisine.macuisine.Services;

 import com.cuisine.macuisine.Entites.Post;
 import com.cuisine.macuisine.Repositories.PostRepository;
import com.cuisine.macuisine.exceptions.ErrorStrings;
import com.cuisine.macuisine.exceptions.MyInternalServerErrorException;
import com.cuisine.macuisine.exceptions.MyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostImpl implements IPost {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }


    @Override
    public void savePost(Post post) {
        try {
            postRepository.save(post);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.CLINT_NOT_FOUND));
    }

    public void deletePost(Long id) {
        try {
            postRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    public Post updatePost(Long id, Post post) {
        Post postdb = postRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.Post_NOT_FOUND));
        try {
            postdb.setImage(post.getImage());
            postdb.setDescription(post.getDescription());
            postdb.setUser(post.getUser());
            postdb.setDatePub(post.getDatePub());
            postdb.setComments(post.getComments());
            postRepository.save(postdb);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
        return postdb;
    }

    @Override
    public Post updatePostLikes(Long id, int likes) {
        Post post = postRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.Post_NOT_FOUND));

        try {
            post.setLikes(likes);
            postRepository.save(post);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }

        return post;
    }
}
