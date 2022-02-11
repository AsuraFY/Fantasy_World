package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Webtoonreview {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id", nullable = false)
    private int reviewId;
    @Basic
    @Column(name = "member", nullable = false, length = 255, updatable = false , insertable = false)
    private String member;
    @Basic
    @Column(name = "webtoon_id", nullable = false, updatable = false , insertable = false)
    private int webtoonId;
    @Basic
    @Column(name = "review", nullable = false, length = 5000)
    private String review;
    @ManyToOne
    @JoinColumn(name = "member", referencedColumnName = "username", nullable = false)
    private User userByMember;
    @ManyToOne
    @JoinColumn(name = "webtoon_id", referencedColumnName = "webtoon_id", nullable = false)
    private Webtoon webtoonByWebtoonId;

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

    public int getWebtoonId() {
        return webtoonId;
    }

    public void setWebtoonId(int webtoonId) {
        this.webtoonId = webtoonId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Webtoonreview that = (Webtoonreview) o;
        return reviewId == that.reviewId && webtoonId == that.webtoonId && Objects.equals(member, that.member) && Objects.equals(review, that.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, member, webtoonId, review);
    }

    public User getUserByMember() {
        return userByMember;
    }

    public void setUserByMember(User userByMember) {
        this.userByMember = userByMember;
    }

    public Webtoon getWebtoonByWebtoonId() {
        return webtoonByWebtoonId;
    }

    public void setWebtoonByWebtoonId(Webtoon webtoonByWebtoonId) {
        this.webtoonByWebtoonId = webtoonByWebtoonId;
    }
}
