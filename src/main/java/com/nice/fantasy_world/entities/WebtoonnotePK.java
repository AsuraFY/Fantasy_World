package com.nice.fantasy_world.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class WebtoonnotePK implements Serializable {
    @Column(name = "member", nullable = false, length = 255, updatable = false , insertable = false)
    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String member;
    @Column(name = "webtoon_id", nullable = false, updatable = false , insertable = false)
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int webtoonId;
    public WebtoonnotePK(){}
    public WebtoonnotePK(int webtoonId, String member) {
        this.member = member;
        this.webtoonId = webtoonId;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public int getWebtoonId() {
        return webtoonId;
    }

    public void setWebtoonId(int webtoonId) {
        this.webtoonId = webtoonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebtoonnotePK that = (WebtoonnotePK) o;
        return webtoonId == that.webtoonId && Objects.equals(member, that.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, webtoonId);
    }
}
