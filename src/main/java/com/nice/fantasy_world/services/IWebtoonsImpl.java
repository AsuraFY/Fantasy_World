package com.nice.fantasy_world.services;

import com.nice.fantasy_world.dao.WebtoonsDao;
import com.nice.fantasy_world.entities.Webtoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class IWebtoonsImpl implements IWebtoons{
    @Autowired
    WebtoonsDao webtoonsDao;
    @Override
    public List<Webtoon> getAll() {
        return (List<Webtoon>) webtoonsDao.findAll() ;
    }
    @Override
    public Optional<Webtoon> getById(int id){return webtoonsDao.findById(id); }
    @Override
     public Webtoon addWebtoon(Webtoon webtoon) {return webtoonsDao.save(webtoon);}
    @Override
    public void deleteById(int id) {webtoonsDao.deleteById(id);}
    @Override
    public Webtoon updateWebtoon(Webtoon newwebtoon, int id) {
        if (webtoonsDao.findById(id).isPresent()) {
            Webtoon webtoon= webtoonsDao.findById(id).get();
            webtoon.setAuthor(newwebtoon.getAuthor());
            webtoon.setTitle(newwebtoon.getTitle());
            webtoon.setChapters(newwebtoon.getChapters());
            webtoon.setStatus(newwebtoon.getStatus());
            webtoon.setSypnosis(newwebtoon.getSypnosis());
            return webtoonsDao.save(webtoon);
        }else{
            return null;
        }
    }
}
