package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Novel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "novel_id", nullable = false)
    private int novelId;
    @Basic
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Basic
    @Column(name = "author", nullable = false, length = 255)
    private String author;
    @Basic
    @Column(name = "chapters", nullable = true)
    private Integer chapters;
    @Basic
    @Column(name = "status", nullable = false, length = 20)
    private String status;
    @Basic
    @Column(name = "sypnosis", nullable = true, length = 2500)
    private String sypnosis;
    @Basic
    @Column(name = "novel_rate", nullable = true)
    private Integer novelRate;

    public int getNovelId() {
        return novelId;
    }

    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getChapters() {
        return chapters;
    }

    public void setChapters(Integer chapters) {
        this.chapters = chapters;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSypnosis() {
        return sypnosis;
    }

    public void setSypnosis(String sypnosis) {
        this.sypnosis = sypnosis;
    }

    public Integer getNovelRate() {
        return novelRate;
    }

    public void setNovelRate(Integer novelRate) {
        this.novelRate = novelRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novel novel = (Novel) o;
        return novelId == novel.novelId && Objects.equals(title, novel.title) && Objects.equals(author, novel.author) && Objects.equals(chapters, novel.chapters) && Objects.equals(status, novel.status) && Objects.equals(sypnosis, novel.sypnosis) && Objects.equals(novelRate, novel.novelRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(novelId, title, author, chapters, status, sypnosis, novelRate);
    }
}
