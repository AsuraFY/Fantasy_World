package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Collection;
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
    @Column(name = "author", nullable = true, length = 255)
    private String author;
    @Basic
    @Column(name = "chapters", nullable = true)
    private Integer chapters;
    @Basic
    @Column(name = "status", nullable = true, length = 20)
    private String status;
    @Basic
    @Column(name = "sypnosis", nullable = true, length = 2500)
    private String sypnosis;
    @Basic
    @Column(name = "rate", nullable = true)
    private Integer rate;
    @Basic
    @Column(name = "posted_by", nullable = true, length = 255, updatable = false , insertable = false)
    private String postedBy;
    @Basic
    @Column(name = "image_id", nullable = true, updatable = false , insertable = false)
    private Integer imageId;
    @ManyToOne
    @JoinColumn(name = "posted_by", referencedColumnName = "username")
    private User userByPostedBy;
    @ManyToOne
    @JoinColumn(name = "image_id", referencedColumnName = "image_id")
    private Image imageByImageId;
    @OneToMany(mappedBy = "novelByNovelId")
    private Collection<Novelmember> novelmembersByNovelId;
    @OneToMany(mappedBy = "novelByNovelId")
    private Collection<Novelnote> novelnotesByNovelId;
    @OneToMany(mappedBy = "novelByNovelId")
    private Collection<Novelreview> novelreviewsByNovelId;

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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novel novel = (Novel) o;
        return novelId == novel.novelId && Objects.equals(title, novel.title) && Objects.equals(author, novel.author) && Objects.equals(chapters, novel.chapters) && Objects.equals(status, novel.status) && Objects.equals(sypnosis, novel.sypnosis) && Objects.equals(rate, novel.rate) && Objects.equals(postedBy, novel.postedBy) && Objects.equals(imageId, novel.imageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(novelId, title, author, chapters, status, sypnosis, rate, postedBy, imageId);
    }

    public User getUserByPostedBy() {
        return userByPostedBy;
    }

    public void setUserByPostedBy(User userByPostedBy) {
        this.userByPostedBy = userByPostedBy;
    }

    public Image getImageByImageId() {
        return imageByImageId;
    }

    public void setImageByImageId(Image imageByImageId) {
        this.imageByImageId = imageByImageId;
    }

    public Collection<Novelmember> getNovelmembersByNovelId() {
        return novelmembersByNovelId;
    }

    public void setNovelmembersByNovelId(Collection<Novelmember> novelmembersByNovelId) {
        this.novelmembersByNovelId = novelmembersByNovelId;
    }

    public Collection<Novelnote> getNovelnotesByNovelId() {
        return novelnotesByNovelId;
    }

    public void setNovelnotesByNovelId(Collection<Novelnote> novelnotesByNovelId) {
        this.novelnotesByNovelId = novelnotesByNovelId;
    }

    public Collection<Novelreview> getNovelreviewsByNovelId() {
        return novelreviewsByNovelId;
    }

    public void setNovelreviewsByNovelId(Collection<Novelreview> novelreviewsByNovelId) {
        this.novelreviewsByNovelId = novelreviewsByNovelId;
    }
}
