package com.nice.fantasy_world.services;

import com.nice.fantasy_world.dao.NovelsDao;
import com.nice.fantasy_world.entities.Novel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class INovelsImpl implements INovels{
    @Autowired
    NovelsDao novelsDao;
    @Override
    public List<Novel> getAll() {return (List<Novel>) novelsDao.findAll();}
    @Override
    public Optional<Novel> getById(int id) {return novelsDao.findById(id);}
    @Override
    public Novel addNovel(Novel novel) {return novelsDao.save(novel);}
    @Override
    public void deleteById(int id) {novelsDao.deleteById(id);}
    @Override
    public Novel updateNovel(Novel newnovel, int id) {
        if (novelsDao.findById(id).isPresent()) {
            Novel novel= novelsDao.findById(id).get();

            novel.setAuthor(newnovel.getAuthor());
            novel.setTitle(newnovel.getTitle());
            novel.setChapters(newnovel.getChapters());
            novel.setStatus(newnovel.getStatus());
            novel.setSypnosis(newnovel.getSypnosis());
            return novelsDao.save(novel);
        }else{
            return null;
        }
    }

}
