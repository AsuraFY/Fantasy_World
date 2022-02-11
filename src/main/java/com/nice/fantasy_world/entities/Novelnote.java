package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(NovelnotePK.class)
public class Novelnote {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "member", nullable = false, length = 255)
    private String member;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "novel_id", nullable = false)
    private int novelId;
    @Basic
    @Column(name = "note", nullable = false)
    private int note;
    @ManyToOne
    @JoinColumn(name = "member", referencedColumnName = "username", nullable = false, updatable = false , insertable = false)
    private User userByMember;
    @ManyToOne
    @JoinColumn(name = "novel_id", referencedColumnName = "novel_id", nullable = false, updatable = false , insertable = false)
    private Novel novelByNovelId;

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public int getNovelId() {
        return novelId;
    }

    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novelnote novelnote = (Novelnote) o;
        return novelId == novelnote.novelId && note == novelnote.note && Objects.equals(member, novelnote.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, novelId, note);
    }

    public User getUserByMember() {
        return userByMember;
    }

    public void setUserByMember(User userByMember) {
        this.userByMember = userByMember;
    }

    public Novel getNovelByNovelId() {
        return novelByNovelId;
    }

    public void setNovelByNovelId(Novel novelByNovelId) {
        this.novelByNovelId = novelByNovelId;
    }
}
