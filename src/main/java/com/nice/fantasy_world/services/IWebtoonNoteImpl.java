package com.nice.fantasy_world.services;

import com.nice.fantasy_world.dao.WebtoonNoteDao;
import com.nice.fantasy_world.entities.Webtoonnote;
import com.nice.fantasy_world.entities.WebtoonnotePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IWebtoonNoteImpl implements  IWebtoonNote{

    @Autowired
    WebtoonNoteDao noteDao;
    @Override
    public List<Webtoonnote> getAll()
    {return (List<Webtoonnote>) noteDao.findAll();}
    @Override
    public Optional<Webtoonnote> getByPk(WebtoonnotePK id)
    {   if (noteDao.findById(id).isPresent()){
            return noteDao.findById(id);
        } else{ return null;}
    }
    @Override
    public Webtoonnote addNote(Webtoonnote note)
    {return noteDao.save(note);}



    @Override
    public Webtoonnote updateNote(Webtoonnote newnote, WebtoonnotePK id) {
        if (noteDao.findById(id).isPresent()){
            Webtoonnote note = noteDao.findById(id).get();
            note.setNote(newnote.getNote());
            note.setIdwebtoon(newnote.getIdwebtoon()); ;
            note.setIduser(newnote.getIduser());
            return noteDao.save(note);
        }else{
            return null;
        }
    }

    @Override
    public void deleteById(WebtoonnotePK id)
    {noteDao.deleteById(id);}
}
