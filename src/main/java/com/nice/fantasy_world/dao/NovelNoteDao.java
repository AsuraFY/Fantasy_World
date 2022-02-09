package com.nice.fantasy_world.dao;

import com.nice.fantasy_world.entities.Novelnote;
import com.nice.fantasy_world.entities.NovelnotePK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelNoteDao extends CrudRepository <Novelnote, NovelnotePK>{
  //  public NovelNote findByPk(NovelNotePK id);
}
