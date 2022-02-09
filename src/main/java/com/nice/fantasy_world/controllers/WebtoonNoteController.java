package com.nice.fantasy_world.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nice.fantasy_world.entities.Webtoonnote;
import com.nice.fantasy_world.entities.WebtoonnotePK;
import com.nice.fantasy_world.services.IWebtoonNoteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WebtoonNoteController {
    @Autowired
    IWebtoonNoteImpl iNote;

    @GetMapping("/api/webtoonnotes")
    List<Webtoonnote> getAll() {
        return iNote.getAll();
    }

    @GetMapping("/api/webtoonnotes/{idwebtoon}/{iduser}")
    Webtoonnote getByPk(@PathVariable("idwebtoon") int idwebtoon, @PathVariable("iduser") int iduser){

        if (iNote.getByPk(new WebtoonnotePK(idwebtoon, iduser)).isPresent()){
            return iNote.getByPk(new WebtoonnotePK(idwebtoon, iduser)).get();
        }else{
            return null;
        }
    }


    @DeleteMapping(value = "/api/webtoonnotes/{idwebtoon}/{iduser}")
    String deletedById(WebtoonnotePK id){
        // NovelnotePK id = new NovelnotePK(idnovel, iduser);
        iNote.deleteById(id);
        return "deleted" ;
    }

    @PostMapping(value="/api/webtoonnotes" ,consumes ="application/json")

    Webtoonnote addNote(@RequestBody String jsonNote ) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Webtoonnote note = om.readValue(jsonNote, Webtoonnote.class );
        System.out.println(note);
        return iNote.addNote(note);
    }

    @PutMapping(value="/api/webtoonnotes/{idwebtoon}/{iduser}" ,consumes ="application/json")
    Webtoonnote updateNote(@PathVariable ("idwebtoon") int idwebtoon, @PathVariable("iduser") int iduser, @RequestBody String jsonNote) throws JsonProcessingException{
        WebtoonnotePK id =  new WebtoonnotePK(idwebtoon, iduser);
        ObjectMapper om = new ObjectMapper();
        Webtoonnote notejson = om.readValue(jsonNote, Webtoonnote.class);
        return iNote.updateNote(notejson, id);
    }
}
