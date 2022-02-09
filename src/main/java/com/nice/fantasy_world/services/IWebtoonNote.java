package com.nice.fantasy_world.services;

import com.nice.fantasy_world.entities.Webtoonnote;
import com.nice.fantasy_world.entities.WebtoonnotePK;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IWebtoonNote {
    List<Webtoonnote> getAll();
    Optional<Webtoonnote> getByPk(WebtoonnotePK id);
    Webtoonnote addNote(Webtoonnote note) ;

    Webtoonnote updateNote(Webtoonnote newnote, WebtoonnotePK id);

    void deleteById(WebtoonnotePK id);
}
