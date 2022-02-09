package com.nice.fantasy_world.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class NovelnotePK implements Serializable {
    @Column(name = "idnovel", nullable = false)
    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idnovel;
    @Column(name = "iduser", nullable = false)
    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduser;

    public  NovelnotePK(){}
    public  NovelnotePK(int idnovel, int iduser) {
        this.idnovel = idnovel;
        this.iduser = iduser;
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
        NovelnotePK that = (NovelnotePK) o;
        return idnovel == that.idnovel && iduser == that.iduser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idnovel, iduser);
    }
}
