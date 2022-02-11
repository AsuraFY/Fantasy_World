package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(NovelmemberPK.class)
public class Novelmember {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "member", nullable = false, length = 255, updatable = false , insertable = false)
    private String member;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "novel_id", nullable = false, updatable = false , insertable = false)
    private int novelId;
    @ManyToOne
    @JoinColumn(name = "member", referencedColumnName = "username", nullable = false)
    private User userByMember;
    @ManyToOne
    @JoinColumn(name = "novel_id", referencedColumnName = "novel_id", nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novelmember that = (Novelmember) o;
        return novelId == that.novelId && Objects.equals(member, that.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, novelId);
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
