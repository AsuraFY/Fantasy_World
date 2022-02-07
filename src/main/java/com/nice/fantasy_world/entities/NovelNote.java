package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "novel_note", schema = "fantasy_world", catalog = "")
@IdClass(NovelNotePK.class)
public class NovelNote {
    @Basic
    @Column(name = "novel_note", nullable = true)
    private Integer novelNote;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "novel_id", nullable = false)
    private int novelId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;

    public Integer getNovelNote() {
        return novelNote;
    }

    public void setNovelNote(Integer novelNote) {
        this.novelNote = novelNote;
    }

    public int getNovelId() {
        return novelId;
    }

    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NovelNote novelNote1 = (NovelNote) o;
        return novelId == novelNote1.novelId && userId == novelNote1.userId && Objects.equals(novelNote, novelNote1.novelNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(novelNote, novelId, userId);
    }
}
