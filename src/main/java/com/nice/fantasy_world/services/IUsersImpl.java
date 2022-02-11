package com.nice.fantasy_world.services;

import com.nice.fantasy_world.dao.UsersDao;
import com.nice.fantasy_world.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IUsersImpl implements IUsers{

    @Autowired
    UsersDao usersDao;
    @Override
    public List<User> getAll() {return (List<User>) usersDao.findAll() ; }
    @Override
    public Optional<User> getByUsername(String username ) {return usersDao.findById(username);}
    @Override
    public User addUser(User user){return usersDao.save(user) ;}
    @Override
    public void deleteById(String username) { usersDao.deleteById(username); }
    @Override
    public User updateUser(User newuser, String username) {
        if (usersDao.findById(username).isPresent()) {
            User user= usersDao.findById(username).get();

            user.setUsername(newuser.getUsername());
            user.setEmail(newuser.getEmail());
            user.setPwd(newuser.getPwd());
            user.setImageUrl(newuser.getImageUrl());
            return usersDao.save(user);
        }else{
            return null;
        }
    }
}
