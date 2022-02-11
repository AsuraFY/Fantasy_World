package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(WebtoonmemberPK.class)
public class Webtoonmember {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "member", nullable = false, length = 255, updatable = false , insertable = false)
    private String member;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "webtoon_id", nullable = false, updatable = false , insertable = false)
    private int webtoonId;
    @ManyToOne
    @JoinColumn(name = "member", referencedColumnName = "username", nullable = false)
    private User userByMember;
    @ManyToOne
    @JoinColumn(name = "webtoon_id", referencedColumnName = "webtoon_id", nullable = false)
    private Webtoon webtoonByWebtoonId;

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
        Webtoonmember that = (Webtoonmember) o;
        return webtoonId == that.webtoonId && Objects.equals(member, that.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, webtoonId);
    }

    public User getUserByMember() {
        return userByMember;
    }

    public void setUserByMember(User userByMember) {
        this.userByMember = userByMember;
    }

    public Webtoon getWebtoonByWebtoonId() {
        return webtoonByWebtoonId;
    }

    public void setWebtoonByWebtoonId(Webtoon webtoonByWebtoonId) {
        this.webtoonByWebtoonId = webtoonByWebtoonId;
    }
}
