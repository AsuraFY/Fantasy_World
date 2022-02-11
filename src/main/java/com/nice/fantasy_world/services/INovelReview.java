package com.nice.fantasy_world.services;

import com.nice.fantasy_world.entities.Novelreview;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface INovelReview {
    List<Novelreview> getAll();
    Optional<Novelreview> getById(int id);
    Novelreview addReview(Novelreview novelreview);
    Novelreview updateReview(Novelreview novelreview, int id);
    void deleteById(int id);
}
