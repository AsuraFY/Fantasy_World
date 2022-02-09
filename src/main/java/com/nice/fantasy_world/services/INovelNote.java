package com.nice.fantasy_world.services;

import com.nice.fantasy_world.entities.Novelnote;
import com.nice.fantasy_world.entities.NovelnotePK;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface INovelNote {

   List<Novelnote> getAll();
   Optional<Novelnote> getByPk(NovelnotePK id);
   Novelnote addNote(Novelnote note) ;

   Novelnote updateNote(Novelnote newnote, NovelnotePK id);

   void deleteById(NovelnotePK id);
}
