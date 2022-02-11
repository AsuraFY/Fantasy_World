package com.nice.fantasy_world.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class NovelmemberPK implements Serializable {
    @Column(name = "member", nullable = false, length = 255, updatable = false , insertable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String member;
    @Column(name = "novel_id", nullable = false, updatable = false , insertable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int novelId;

    public NovelmemberPK(String member, int novelId) {
        this.member = member;
        this.novelId = novelId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NovelmemberPK that = (NovelmemberPK) o;
        return novelId == that.novelId && Objects.equals(member, that.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, novelId);
    }
}
