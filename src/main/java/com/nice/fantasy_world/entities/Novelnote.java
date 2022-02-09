package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(NovelnotePK.class)
public class Novelnote {
    @Basic
    @Column(name = "note", nullable = true)
    private Integer note;
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idnovel", nullable = false)
    private int idnovel;
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iduser", nullable = false)
    private int iduser;
    @ManyToOne
    @JoinColumn(name = "idnovel", referencedColumnName = "idnovel", nullable = false, insertable= false, updatable= false )
    private Novel novelByIdnovel;
    @ManyToOne
    @JoinColumn(name = "iduser", referencedColumnName = "iduser", nullable = false,insertable= false, updatable= false )
    private User userByIduser;

    public Novelnote(Novel novelByIdnovel, User userByIduser) {
        this.novelByIdnovel = novelByIdnovel;
        this.userByIduser = userByIduser;
    }
    public Novelnote(){}

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public int getIdnovel() {
        return idnovel;
    }

    public void setIdnovel(int idnovel) {
        this.idnovel = idnovel;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novelnote novelnote = (Novelnote) o;
        return idnovel == novelnote.idnovel && iduser == novelnote.iduser && Objects.equals(note, novelnote.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note, idnovel, iduser);
    }

//    public Novel getNovelByIdnovel() {
//        return novelByIdnovel;
//    }
//
//    public void setNovelByIdnovel(Novel novelByIdnovel) {
//        this.novelByIdnovel = novelByIdnovel;
//    }
//
//    public User getUserByIduser() {
//        return userByIduser;
//    }
//
//    public void setUserByIduser(User userByIduser) {
//        this.userByIduser = userByIduser;
//    }
}
