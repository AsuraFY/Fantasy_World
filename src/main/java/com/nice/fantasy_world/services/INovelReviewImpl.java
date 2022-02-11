package com.nice.fantasy_world.services;

import com.nice.fantasy_world.dao.NovelReviewDao;
import com.nice.fantasy_world.entities.Novelreview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class INovelReviewImpl implements  INovelReview{
    @Autowired
    NovelReviewDao reviewDao;
    @Override
    public List<Novelreview> getAll() {
        return (List<Novelreview>) reviewDao.findAll();
    }

    @Override
    public Optional<Novelreview> getById(int id) {
        if (reviewDao.findById(id).isPresent()){
            return  Optional.of(reviewDao.findById(id).get());
        }else{
        return Optional.empty();}
    }

    @Override
    public Novelreview addReview(Novelreview novelreview) {
        return reviewDao.save(novelreview);
    }

    @Override
    public Novelreview updateReview(Novelreview novelreview, int id) {
        if (reviewDao.findById(id).isPresent()){
            Novelreview newreview =reviewDao.findById(id).get();
            novelreview.setReview(newreview.getReview());
            novelreview.setDate(newreview.getDate());
            return reviewDao.save(novelreview) ;
        }else{
            return null;}
    }

    @Override
    public void deleteById(int id) {
    reviewDao.deleteById(id);
    }
}
