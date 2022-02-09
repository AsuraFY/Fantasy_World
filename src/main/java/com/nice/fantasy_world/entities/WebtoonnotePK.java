package com.nice.fantasy_world.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class WebtoonnotePK implements Serializable {
    @Column(name = "idwebtoon", nullable = false)
    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idwebtoon;
    @Column(name = "iduser", nullable = false)
    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduser;
    public WebtoonnotePK(){}

    public WebtoonnotePK(int idwebtoon, int iduser) {
        this.idwebtoon = idwebtoon;
        this.iduser =iduser;
    }

    public int getIdwebtoon() {
        return idwebtoon;
    }

    public void setIdwebtoon(int idwebtoon) {
        this.idwebtoon = idwebtoon;
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
        WebtoonnotePK that = (WebtoonnotePK) o;
        return idwebtoon == that.idwebtoon && iduser == that.iduser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idwebtoon, iduser);
    }
}
