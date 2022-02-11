package com.nice.fantasy_world.services;

import com.nice.fantasy_world.entities.Novelmember;
import com.nice.fantasy_world.entities.NovelmemberPK;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface INovelMember {
    List<Novelmember> getAll();
    Optional<Novelmember> getByPk(NovelmemberPK id);
    Novelmember addToList(Novelmember novelmember);
    void removeFromList(NovelmemberPK id);

}
