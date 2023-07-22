package com.cuisine.macuisine.Repositories;


import com.cuisine.macuisine.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
