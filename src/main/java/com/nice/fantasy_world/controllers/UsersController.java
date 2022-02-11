package com.nice.fantasy_world.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nice.fantasy_world.entities.User;
import com.nice.fantasy_world.services.IUsersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsersController {
@Autowired
IUsersImpl iUsers;

    @GetMapping("/api/users")
    List<User> getAll() {return iUsers.getAll(); }

    @GetMapping("/api/users/{username}")
    User getById(@PathVariable("username") String username){
        if (iUsers.getByUsername(username).isPresent()){
            return iUsers.getByUsername(username).get();
        }else{
            return null;
        }
    }

    @DeleteMapping("/api/users/{username}")

    String deleteById(@PathVariable("username") String username){
        iUsers.deleteById(username);
        return "deleted";
    }



    @PostMapping(value="/api/users", consumes ="application/json")

    User addUser(@RequestBody String jsonUser) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        User user = om.readValue(jsonUser, User.class);
        return iUsers.addUser(user);
    }

    @PutMapping("/api/users/{username}")
    User updateUser(@PathVariable("username" ) String username, @RequestBody String jsonUser) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        User userjson = om.readValue(jsonUser, User.class);
        return iUsers.updateUser(userjson, username);



    }

}
