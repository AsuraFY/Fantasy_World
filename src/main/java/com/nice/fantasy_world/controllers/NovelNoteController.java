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

 @GetMapping("/api/novelnotes")
 List<Novelnote> getAll() {
     return iNote.getAll();
 }

 @GetMapping("/api/novelnotes/{idnovel}/{iduser}")
 Novelnote getByPk(@PathVariable ("idnovel") int idnovel, @PathVariable("iduser") int iduser){

         if (iNote.getByPk(new NovelnotePK(idnovel, iduser)).isPresent()){
         return iNote.getByPk(new NovelnotePK(idnovel, iduser)).get();
     }else{
         return null;
     }
 }


 @DeleteMapping(value = "/api/novelnotes/{idnovel}/{iduser}")
    String deletedById(NovelnotePK id){
     iNote.deleteById(id);
     return "deleted" ;
 }

 @PostMapping(value="/api/novelnotes" ,consumes ="application/json")

 Novelnote addNote(@RequestBody String jsonNote ) throws JsonProcessingException {
     ObjectMapper om = new ObjectMapper();
     Novelnote note = om.readValue(jsonNote, Novelnote.class );
     System.out.println(note);
     return iNote.addNote(note);
 }

 @PutMapping(value="/api/novelnotes/{idnovel}/{iduser}" ,consumes ="application/json")
 Novelnote updateNote(@PathVariable ("idnovel") int idnovel, @PathVariable("iduser") int iduser, @RequestBody String jsonNote) throws JsonProcessingException{
     NovelnotePK id =  new NovelnotePK(idnovel, iduser);
     ObjectMapper om = new ObjectMapper();
     Novelnote notejson = om.readValue(jsonNote, Novelnote.class);
        return iNote.updateNote(notejson, id);
    }
}