package com.nice.fantasy_world.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nice.fantasy_world.entities.Novel;
import com.nice.fantasy_world.services.INovelsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NovelsController {
    @Autowired
    INovelsImpl iNovels ;
    @GetMapping("/api/novels")
    List<Novel> getAll() {
        System.out.println("Requesting get");
        return iNovels.getAll();}

    @GetMapping("/api/novels/{id}")
    Novel getById(@PathVariable("id") int id) {if (iNovels.getById(id).isPresent()) {
        return (iNovels.getById(id).get());
    }else{
        return null;
    }}

    @PostMapping(value = "/api/novels", consumes ="application/json" )
    Novel addNovel(@RequestBody String jsonNovel) throws JsonProcessingException{
        ObjectMapper om = new ObjectMapper();
        Novel novel = om.readValue(jsonNovel, Novel.class);
        return iNovels.addNovel(novel);
    }
        @DeleteMapping("/api/novels/{id}")

         String deleteById(@PathVariable("id") int id){
        iNovels.deleteById(id);
        return  "deleted";
        }

        @PutMapping("/api/novels/{id}")
        Novel updateNovel(@PathVariable("id" ) int id, @RequestBody String jsonNovel) throws JsonProcessingException {
            ObjectMapper mp = new ObjectMapper();
            Novel noveljson = mp.readValue(jsonNovel, Novel.class);
            return iNovels.updateNovel(noveljson, id);



    }


}