package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Novelreview {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id", nullable = false)
    private int reviewId;
    @Basic
    @Column(name = "member", nullable = false, length = 255, updatable = false , insertable = false)
    private String member;
    @Basic
    @Column(name = "novel_id", nullable = false, updatable = false , insertable = false)
    private int novelId;
    @Basic
    @Column(name = "review", nullable = false, length = 5000)
    private String review;
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "member", referencedColumnName = "username", nullable = false)
    private User userByMember;
    @ManyToOne
    @JoinColumn(name = "novel_id", referencedColumnName = "novel_id", nullable = false)
    private Novel novelByNovelId;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novelreview that = (Novelreview) o;
        return reviewId == that.reviewId && novelId == that.novelId && Objects.equals(member, that.member) && Objects.equals(review, that.review) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, member, novelId, review, date);
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
