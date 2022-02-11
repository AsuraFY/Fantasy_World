package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Image {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "image_id", nullable = false)
    private int imageId;
    @Basic
    @Column(name = "image_url", nullable = false, length = 2000)
    private String imageUrl;
    @OneToMany(mappedBy = "imageByImageId")
    private Collection<Novel> novelsByImageId;
    @OneToMany(mappedBy = "imageByImageId")
    private Collection<Webtoon> webtoonsByImageId;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
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
        Image image = (Image) o;
        return imageId == image.imageId && Objects.equals(imageUrl, image.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, imageUrl);
    }

    public Collection<Novel> getNovelsByImageId() {
        return novelsByImageId;
    }

    public void setNovelsByImageId(Collection<Novel> novelsByImageId) {
        this.novelsByImageId = novelsByImageId;
    }

    public Collection<Webtoon> getWebtoonsByImageId() {
        return webtoonsByImageId;
    }

    public void setWebtoonsByImageId(Collection<Webtoon> webtoonsByImageId) {
        this.webtoonsByImageId = webtoonsByImageId;
    }
}
