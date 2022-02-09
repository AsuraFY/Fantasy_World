package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Novel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idnovel", nullable = false)
    private int idnovel;
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
    @Column(name = "novelrate", nullable = true)
    private Integer novelrate;
    @OneToMany(mappedBy = "novelByIdnovel")
    private Collection<Novelnote> novelnotesByIdnovel;



    public int getIdnovel() {
        return idnovel;
    }

    public void setIdnovel(int idnovel) {
        this.idnovel = idnovel;
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

    public Integer getNovelrate() {
        return novelrate;
    }

    public void setNovelrate(Integer novelrate) {
        this.novelrate = novelrate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novel novel = (Novel) o;
        return idnovel == novel.idnovel && Objects.equals(title, novel.title) && Objects.equals(author, novel.author) && Objects.equals(chapters, novel.chapters) && Objects.equals(status, novel.status) && Objects.equals(sypnosis, novel.sypnosis) && Objects.equals(novelrate, novel.novelrate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idnovel, title, author, chapters, status, sypnosis, novelrate);
    }

//    public Collection<Novelnote> getNovelnotesByIdnovel() {
//        return novelnotesByIdnovel;
//    }
//
//    public void setNovelnotesByIdnovel(Collection<Novelnote> novelnotesByIdnovel) {
//        this.novelnotesByIdnovel = novelnotesByIdnovel;
//    }
}
