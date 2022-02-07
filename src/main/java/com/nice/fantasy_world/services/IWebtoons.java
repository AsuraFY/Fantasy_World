package com.nice.fantasy_world.services;

import com.nice.fantasy_world.entities.Webtoon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface IWebtoons {
    List<Webtoon> getAll();
    Optional<Webtoon> getById(int id);
    Webtoon addWebtoon(Webtoon webtoon);
   void deleteById(int id);
    Webtoon updateWebtoon(Webtoon webtoon, int id);
}
