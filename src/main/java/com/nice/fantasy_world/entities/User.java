package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User {
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "username", nullable = false, length = 255 )
    private String username;
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "pwd", nullable = false, length = 255)
    private String pwd;
    @Basic
    @Column(name = "image_url", nullable = true, length = 2000)
    private String imageUrl;
    @OneToMany(mappedBy = "userByPostedBy")
    private Collection<Novel> novelsByUsername;
    @OneToMany(mappedBy = "userByMember")
    private Collection<Novelmember> novelmembersByUsername;
    @OneToMany(mappedBy = "userByMember")
    private Collection<Novelnote> novelnotesByUsername;
    @OneToMany(mappedBy = "userByMember")
    private Collection<Novelreview> novelreviewsByUsername;
    @OneToMany(mappedBy = "userByPostedBy")
    private Collection<Webtoon> webtoonsByUsername;
    @OneToMany(mappedBy = "userByMember")
    private Collection<Webtoonmember> webtoonmembersByUsername;
    @OneToMany(mappedBy = "userByMember")
    private Collection<Webtoonnote> webtoonnotesByUsername;
    @OneToMany(mappedBy = "userByMember")
    private Collection<Webtoonreview> webtoonreviewsByUsername;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(pwd, user.pwd) && Objects.equals(imageUrl, user.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, pwd, imageUrl);
    }

    public Collection<Novel> getNovelsByUsername() {
        return novelsByUsername;
    }

    public void setNovelsByUsername(Collection<Novel> novelsByUsername) {
        this.novelsByUsername = novelsByUsername;
    }

    public Collection<Novelmember> getNovelmembersByUsername() {
        return novelmembersByUsername;
    }

    public void setNovelmembersByUsername(Collection<Novelmember> novelmembersByUsername) {
        this.novelmembersByUsername = novelmembersByUsername;
    }

    public Collection<Novelnote> getNovelnotesByUsername() {
        return novelnotesByUsername;
    }

    public void setNovelnotesByUsername(Collection<Novelnote> novelnotesByUsername) {
        this.novelnotesByUsername = novelnotesByUsername;
    }

    public Collection<Novelreview> getNovelreviewsByUsername() {
        return novelreviewsByUsername;
    }

    public void setNovelreviewsByUsername(Collection<Novelreview> novelreviewsByUsername) {
        this.novelreviewsByUsername = novelreviewsByUsername;
    }

    public Collection<Webtoon> getWebtoonsByUsername() {
        return webtoonsByUsername;
    }

    public void setWebtoonsByUsername(Collection<Webtoon> webtoonsByUsername) {
        this.webtoonsByUsername = webtoonsByUsername;
    }

    public Collection<Webtoonmember> getWebtoonmembersByUsername() {
        return webtoonmembersByUsername;
    }

    public void setWebtoonmembersByUsername(Collection<Webtoonmember> webtoonmembersByUsername) {
        this.webtoonmembersByUsername = webtoonmembersByUsername;
    }

    public Collection<Webtoonnote> getWebtoonnotesByUsername() {
        return webtoonnotesByUsername;
    }

    public void setWebtoonnotesByUsername(Collection<Webtoonnote> webtoonnotesByUsername) {
        this.webtoonnotesByUsername = webtoonnotesByUsername;
    }

    public Collection<Webtoonreview> getWebtoonreviewsByUsername() {
        return webtoonreviewsByUsername;
    }

    public void setWebtoonreviewsByUsername(Collection<Webtoonreview> webtoonreviewsByUsername) {
        this.webtoonreviewsByUsername = webtoonreviewsByUsername;
    }
}
