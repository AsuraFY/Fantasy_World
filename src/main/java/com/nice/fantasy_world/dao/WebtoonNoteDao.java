package com.nice.fantasy_world.dao;

import com.nice.fantasy_world.entities.Webtoonnote;
import com.nice.fantasy_world.entities.WebtoonnotePK;
import org.springframework.data.repository.CrudRepository;

public interface WebtoonNoteDao extends CrudRepository<Webtoonnote, WebtoonnotePK> {
}
