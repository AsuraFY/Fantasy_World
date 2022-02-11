package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Collection;
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
    @Column(name = "posted_by", nullable = true, length = 255)
    private String postedBy;
    @Basic
    @Column(name = "image_id", nullable = true)
    private Integer imageId;
    @ManyToOne
    @JoinColumn(name = "posted_by", referencedColumnName = "username", updatable = false , insertable = false)
    private User userByPostedBy;
    @ManyToOne
    @JoinColumn(name = "image_id", referencedColumnName = "image_id", updatable = false , insertable = false)
    private Image imageByImageId;
    @OneToMany(mappedBy = "webtoonByWebtoonId")
    private Collection<Webtoonmember> webtoonmembersByWebtoonId;
    @OneToMany(mappedBy = "webtoonByWebtoonId")
    private Collection<Webtoonnote> webtoonnotesByWebtoonId;
    @OneToMany(mappedBy = "webtoonByWebtoonId")
    private Collection<Webtoonreview> webtoonreviewsByWebtoonId;

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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer Rate) {
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
        Webtoon webtoon = (Webtoon) o;
        return webtoonId == webtoon.webtoonId && Objects.equals(title, webtoon.title) && Objects.equals(author, webtoon.author) && Objects.equals(chapters, webtoon.chapters) && Objects.equals(status, webtoon.status) && Objects.equals(sypnosis, webtoon.sypnosis) && Objects.equals(rate, webtoon.rate) && Objects.equals(postedBy, webtoon.postedBy) && Objects.equals(imageId, webtoon.imageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webtoonId, title, author, chapters, status, sypnosis, rate, postedBy, imageId);
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

    public Collection<Webtoonmember> getWebtoonmembersByWebtoonId() {
        return webtoonmembersByWebtoonId;
    }

    public void setWebtoonmembersByWebtoonId(Collection<Webtoonmember> webtoonmembersByWebtoonId) {
        this.webtoonmembersByWebtoonId = webtoonmembersByWebtoonId;
    }

    public Collection<Webtoonnote> getWebtoonnotesByWebtoonId() {
        return webtoonnotesByWebtoonId;
    }

    public void setWebtoonnotesByWebtoonId(Collection<Webtoonnote> webtoonnotesByWebtoonId) {
        this.webtoonnotesByWebtoonId = webtoonnotesByWebtoonId;
    }

    public Collection<Webtoonreview> getWebtoonreviewsByWebtoonId() {
        return webtoonreviewsByWebtoonId;
    }

    public void setWebtoonreviewsByWebtoonId(Collection<Webtoonreview> webtoonreviewsByWebtoonId) {
        this.webtoonreviewsByWebtoonId = webtoonreviewsByWebtoonId;
    }
}
