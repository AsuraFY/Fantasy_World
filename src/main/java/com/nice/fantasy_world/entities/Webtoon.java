package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Webtoon {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "webtoon_id", nullable = false)
    private int webtoonId;
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
    @Column(name = "webtoon_rate", nullable = true)
    private Integer webtoonRate;

    public int getWebtoonId() {
        return webtoonId;
    }

    public void setWebtoonId(int webtoonId) {
        this.webtoonId = webtoonId;
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

    public Integer getWebtoonRate() {
        return webtoonRate;
    }

    public void setWebtoonRate(Integer webtoonRate) {
        this.webtoonRate = webtoonRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Webtoon webtoon = (Webtoon) o;
        return webtoonId == webtoon.webtoonId && Objects.equals(title, webtoon.title) && Objects.equals(author, webtoon.author) && Objects.equals(chapters, webtoon.chapters) && Objects.equals(status, webtoon.status) && Objects.equals(sypnosis, webtoon.sypnosis) && Objects.equals(webtoonRate, webtoon.webtoonRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webtoonId, title, author, chapters, status, sypnosis, webtoonRate);
    }
}
