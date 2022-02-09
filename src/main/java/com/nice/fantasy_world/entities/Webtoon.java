package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Webtoon {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "idwebtoon", nullable = false)
    private int idwebtoon;
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
    @Column(name = "webtoonrate", nullable = true)
    private Integer webtoonrate;
//    @OneToMany(mappedBy = "webtoonByIdwebtoon")
//    private Collection<Webtoonnote> webtoonnotesByIdwebtoon;

    public int getIdwebtoon() {
        return idwebtoon;
    }

    public void setIdwebtoon(int idwebtoon) {
        this.idwebtoon = idwebtoon;
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

    public Integer getWebtoonrate() {
        return webtoonrate;
    }

    public void setWebtoonrate(Integer webtoonrate) {
        this.webtoonrate = webtoonrate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Webtoon webtoon = (Webtoon) o;
        return idwebtoon == webtoon.idwebtoon && Objects.equals(title, webtoon.title) && Objects.equals(author, webtoon.author) && Objects.equals(chapters, webtoon.chapters) && Objects.equals(status, webtoon.status) && Objects.equals(sypnosis, webtoon.sypnosis) && Objects.equals(webtoonrate, webtoon.webtoonrate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idwebtoon, title, author, chapters, status, sypnosis, webtoonrate);
    }

//    public Collection<Webtoonnote> getWebtoonnotesByIdwebtoon() {
//        return webtoonnotesByIdwebtoon;
//    }
//
//    public void setWebtoonnotesByIdwebtoon(Collection<Webtoonnote> webtoonnotesByIdwebtoon) {
//        this.webtoonnotesByIdwebtoon = webtoonnotesByIdwebtoon;
//    }
}
