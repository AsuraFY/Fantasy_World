package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(WebtoonnotePK.class)
public class Webtoonnote {
    @Basic
    @Column(name = "note", nullable = true)
    private Integer note;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idwebtoon", nullable = false)
    private int idwebtoon;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iduser", nullable = false)
    private int iduser;
    @ManyToOne
    @JoinColumn(name = "idwebtoon", referencedColumnName = "idwebtoon", nullable = false, insertable= false, updatable= false)
    private Webtoon webtoonByIdwebtoon;
    @ManyToOne
    @JoinColumn(name = "iduser", referencedColumnName = "iduser", nullable = false, insertable= false, updatable= false)
    private User userByIduser;

//    public Webtoonnote(Webtoon webtoonByIdwebtoon, User userByIduser) {
//        this.webtoonByIdwebtoon = webtoonByIdwebtoon;
//        this.userByIduser = userByIduser;
//    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
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
        Webtoonnote that = (Webtoonnote) o;
        return idwebtoon == that.idwebtoon && iduser == that.iduser && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note, idwebtoon, iduser);
    }

//    public Webtoon getWebtoonByIdwebtoon() {
//        return webtoonByIdwebtoon;
//    }
//
//    public void setWebtoonByIdwebtoon(Webtoon webtoonByIdwebtoon) {
//        this.webtoonByIdwebtoon = webtoonByIdwebtoon;
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
