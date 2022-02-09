package com.nice.fantasy_world.services;

import com.nice.fantasy_world.dao.NovelNoteDao;
import com.nice.fantasy_world.entities.Novelnote;
import com.nice.fantasy_world.entities.NovelnotePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class INovelNoteImpl implements INovelNote {

    @Autowired
    NovelNoteDao noteDao;

    @Override
    public List<Novelnote> getAll()
    {return (List<Novelnote>) noteDao.findAll();}
    @Override
   public Optional<Novelnote> getByPk(NovelnotePK id)
    { if (noteDao.findById(id).isPresent()){
        return noteDao.findById(id);
    }else{
        return null;}
    }
    @Override
    public Novelnote addNote(Novelnote note)
    {return noteDao.save(note);}



    @Override
    public Novelnote updateNote(Novelnote newnote, NovelnotePK id) {
        if (noteDao.findById(id).isPresent()){
            Novelnote note = noteDao.findById(id).get();
            note.setNote(newnote.getNote());
            note.setIdnovel(newnote.getIdnovel());
            note.setIduser(newnote.getIduser()); ;
            return noteDao.save(note);
        }else{
            return null;
        }
    }

    @Override
    public void deleteById(NovelnotePK id)
    {noteDao.deleteById(id);}

}
