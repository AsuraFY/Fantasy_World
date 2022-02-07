package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "webtoon_note", schema = "fantasy_world", catalog = "")
@IdClass(WebtoonNotePK.class)
public class WebtoonNote {
    @Basic
    @Column(name = "webtoon_note", nullable = true)
    private Integer webtoonNote;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "webtoon_id", nullable = false)
    private int webtoonId;

    public Integer getWebtoonNote() {
        return webtoonNote;
    }

    public void setWebtoonNote(Integer webtoonNote) {
        this.webtoonNote = webtoonNote;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        WebtoonNote that = (WebtoonNote) o;
        return userId == that.userId && webtoonId == that.webtoonId && Objects.equals(webtoonNote, that.webtoonNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webtoonNote, userId, webtoonId);
    }
}
