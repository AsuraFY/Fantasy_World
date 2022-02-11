package com.nice.fantasy_world.services;

import com.nice.fantasy_world.dao.NovelMemberDao;
import com.nice.fantasy_world.entities.Novelmember;
import com.nice.fantasy_world.entities.NovelmemberPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class INovelMemberImpl implements INovelMember{
    @Autowired
    NovelMemberDao novelMemberDao;
    @Override
    public List<Novelmember> getAll() {
        return (List<Novelmember>) novelMemberDao.findAll();
    }

    @Override
    public Optional<Novelmember> getByPk(NovelmemberPK id) {
        if (novelMemberDao.findById(id).isPresent()){
            return novelMemberDao.findById(id);
        }else{
            return Optional.empty();}
    }

    @Override
    public Novelmember addToList(Novelmember novelmember) {
        return novelMemberDao.save(novelmember);
    }

    @Override
    public void removeFromList(NovelmemberPK id) {
        novelMemberDao.deleteById(id);
    }
}
