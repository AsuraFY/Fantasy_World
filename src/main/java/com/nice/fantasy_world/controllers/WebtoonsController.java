package com.nice.fantasy_world.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nice.fantasy_world.entities.Webtoon;
import com.nice.fantasy_world.services.IWebtoonsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost/4200")
@RestController
public class WebtoonsController {
    @Autowired
    IWebtoonsImpl iWebtoons;

    @GetMapping("/api/webtoons")
    List<Webtoon> getAll() {return  iWebtoons.getAll();}

    @GetMapping("/api/webtoons/{id}")
    Webtoon getById(@PathVariable("id") int id) {
        if (iWebtoons.getById(id).isPresent()) {
            return iWebtoons.getById(id).get();
        } else {
            return null;
        }
    }

    @PostMapping(value = "/api/webtoons", consumes = "application/json")
    @ResponseBody
    Webtoon addWebtoon(@RequestBody String jsonWebtoon) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Webtoon webtoon = om.readValue(jsonWebtoon, Webtoon.class);
        return iWebtoons.addWebtoon(webtoon);
    }

    @DeleteMapping("api/webtoons/{id}")
    @ResponseBody
    String deleteById(@PathVariable("id") int id) {
    iWebtoons.deleteById(id);
    return "deleted";
   }
    @PutMapping("/api/webtoons/{id}")
    Webtoon updateWebtoon(@PathVariable("id" ) int id, @RequestBody String jsonWebtoon) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Webtoon webtoonjson = om.readValue(jsonWebtoon, Webtoon.class);
        return iWebtoons.updateWebtoon(webtoonjson, id);



    }

}