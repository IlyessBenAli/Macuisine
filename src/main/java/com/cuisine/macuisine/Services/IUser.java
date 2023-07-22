package com.cuisine.macuisine.Services;

import com.cuisine.macuisine.Entites.User;

import java.util.List;

public interface IUser {
    List<User> getAll();

    void saveUser(User user);

    User getUserById(Long id);

    void deleteUser(Long id);

    User updateUser(Long id, User user);
}
