package com.nice.fantasy_world.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nice.fantasy_world.entities.Novelmember;
import com.nice.fantasy_world.entities.NovelmemberPK;
import com.nice.fantasy_world.services.INovelMemberImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NovelMemberController {
    @Autowired
    INovelMemberImpl iNovelMember;

    @GetMapping("/api/novelMember")
    List<Novelmember> getAll() {
        return iNovelMember.getAll();
    }

    @GetMapping("/api/novelMember/{novelId}/{member}")
    Novelmember getByPk(@PathVariable("novelId") int novelId, @PathVariable("member") String member){

        if (iNovelMember.getByPk(new NovelmemberPK(member, novelId)).isPresent()){
            return iNovelMember.getByPk(new NovelmemberPK(member, novelId)).get();
        }else{
            return null;
        }
    }


    @DeleteMapping(value = "/api/novelMember/{novelId}/{member}")
    String removeFromList(NovelmemberPK id){
        iNovelMember.removeFromList(id);
        return "deleted" ;
    }

    @PostMapping(value="/api/novelMember" ,consumes ="application/json")

    Novelmember addToList(@RequestBody String jsonNovelMember ) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Novelmember novelMember = om.readValue(jsonNovelMember, Novelmember.class );
        System.out.println(novelMember);
        return iNovelMember.addToList(novelMember);
    }
}
