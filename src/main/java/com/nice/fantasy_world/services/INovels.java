package com.nice.fantasy_world.services;

import com.nice.fantasy_world.entities.Novel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface INovels {
    List<Novel> getAll();
    Optional<Novel> getById(int id);
    Novel addNovel(Novel novel);
    void deleteById(int id);
    Novel updateNovel(Novel novel, int id);

}
