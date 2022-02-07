package com.nice.fantasy_world.dao;

import com.nice.fantasy_world.entities.Novel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelsDao extends CrudRepository<Novel, Integer> {



}
