package com.nice.fantasy_world.dao;

import com.nice.fantasy_world.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends CrudRepository<User, String> {



}

