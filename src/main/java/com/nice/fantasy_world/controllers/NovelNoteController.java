package com.nice.fantasy_world.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nice.fantasy_world.entities.Novelnote;
import com.nice.fantasy_world.entities.NovelnotePK;
import com.nice.fantasy_world.services.INovelNoteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
public class NovelNoteController {
 @Autowired
 INovelNoteImpl iNote;

 @GetMapping("/api/novelmember")
 List<Novelnote> getAll() {
     return iNote.getAll();
 }

 @GetMapping("/api/novelmember/{novelId}/{member}")
 Novelnote getByPk(@PathVariable ("novelId") int novelId, @PathVariable("member") String member){

         if (iNote.getByPk(new NovelnotePK(novelId, member)).isPresent()){
         return iNote.getByPk(new NovelnotePK(novelId, member)).get();
     }else{
         return null;
     }
 }


 @DeleteMapping(value = "/api/novelmember/{novelId}/{member}")
    String deletedById(NovelnotePK id){
     iNote.deleteById(id);
     return "deleted" ;
 }

 @PostMapping(value="/api/novelmember" ,consumes ="application/json")

 Novelnote addNote(@RequestBody String jsonNote ) throws JsonProcessingException {
     ObjectMapper om = new ObjectMapper();
     Novelnote note = om.readValue(jsonNote, Novelnote.class );
     System.out.println(note);
     return iNote.addNote(note);
 }

 @PutMapping(value="/api/novelmember/{novelId}/{userId}" ,consumes ="application/json")
 Novelnote updateNote(@PathVariable ("novelId") int novelId, @PathVariable("userId") String member, @RequestBody String jsonNote) throws JsonProcessingException{
     NovelnotePK id =  new NovelnotePK(novelId, member);
     ObjectMapper om = new ObjectMapper();
     Novelnote notejson = om.readValue(jsonNote, Novelnote.class);
        return iNote.updateNote(notejson, id);
    }
}