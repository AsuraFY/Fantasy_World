package com.nice.fantasy_world.dao;

import com.nice.fantasy_world.entities.Novelmember;
import com.nice.fantasy_world.entities.NovelmemberPK;
import org.springframework.data.repository.CrudRepository;

public interface NovelMemberDao extends CrudRepository<Novelmember, NovelmemberPK> {
}
