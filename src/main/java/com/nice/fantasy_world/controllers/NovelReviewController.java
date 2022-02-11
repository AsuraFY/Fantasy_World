package com.nice.fantasy_world.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nice.fantasy_world.entities.Novelreview;
import com.nice.fantasy_world.services.INovelReviewImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NovelReviewController {
    @Autowired
    INovelReviewImpl iReview;
    @GetMapping("/api/novelReview")
    List<Novelreview> getAll() {
        System.out.println("Requesting get");
        return iReview.getAll();}

    @GetMapping("/api/novelReview/{id}")
    Novelreview getById(@PathVariable("id") int id) {if (iReview.getById(id).isPresent()) {
        return (iReview.getById(id).get());
    }else{
        return null;
    }}

    @PostMapping(value = "/api/novelReview", consumes ="application/json" )
    Novelreview addNovel(@RequestBody String jsonNovel) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Novelreview review = om.readValue(jsonNovel, Novelreview.class);
        return iReview.addReview(review);
    }
    @DeleteMapping("/api/novelReview/{id}")

    String deleteById(@PathVariable("id") int id){
        iReview.deleteById(id);
        return  "deleted";
    }

    @PutMapping("/api/novelReview/{id}")
    Novelreview updateNovel(@PathVariable("id" ) int id, @RequestBody String jsonReview) throws JsonProcessingException {
        ObjectMapper mp = new ObjectMapper();
        Novelreview reviewjson = mp.readValue(jsonReview, Novelreview.class);
        return iReview.updateReview(reviewjson, id);



    }
}
