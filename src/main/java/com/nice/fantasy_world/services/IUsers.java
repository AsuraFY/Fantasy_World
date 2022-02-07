package com.nice.fantasy_world.services;

import com.nice.fantasy_world.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface IUsers {
    List<User> getAll();
    Optional<User> getById(int id);
    User addUser(User user);
    void deleteById(int id);
    User updateUser( User user, int id);
}
