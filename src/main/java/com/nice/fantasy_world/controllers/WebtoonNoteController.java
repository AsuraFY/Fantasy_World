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

    @GetMapping("/api/webtoonnotes/{webtoonId}/{member}")
    Webtoonnote getByPk(@PathVariable("webtoonId") int webtoonId, @PathVariable("member") String member){

        if (iNote.getByPk(new WebtoonnotePK(webtoonId, member)).isPresent()){
            return iNote.getByPk(new WebtoonnotePK(webtoonId, member)).get();
        }else{
            return null;
        }
    }


    @DeleteMapping(value = "/api/webtoonnotes/{webtoonId}/{member}")
    String deletedById(WebtoonnotePK id){
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

    @PutMapping(value="/api/webtoonnotes/{webtoonId}/{member}" ,consumes ="application/json")
    Webtoonnote updateNote(@PathVariable ("webtoonId") int webtoonId, @PathVariable("member") String member, @RequestBody String jsonNote) throws JsonProcessingException{
        WebtoonnotePK id =  new WebtoonnotePK(webtoonId, member);
        ObjectMapper om = new ObjectMapper();
        Webtoonnote notejson = om.readValue(jsonNote, Webtoonnote.class);
        return iNote.updateNote(notejson, id);
    }
}
