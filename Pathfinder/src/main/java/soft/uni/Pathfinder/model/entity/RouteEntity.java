package soft.uni.Pathfinder.model.entity;

import soft.uni.Pathfinder.model.enums.LevelEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    private String name;

    @ManyToOne
    private UserEntity author;

    @Column(name = "video_url")
    private String videoUrl;

    @OneToMany(targetEntity = CommentsEntity.class ,mappedBy = "route", cascade = CascadeType.ALL)
    private Set<CommentsEntity> comments;

    @OneToMany(mappedBy = "route",  fetch = FetchType.EAGER)
    private Set<PictureEntity> pictures;

    @ManyToMany
    private Set<CategoryEntity> categories;

    public RouteEntity() {
        this.comments = new HashSet<>();
        this.categories = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<CommentsEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentsEntity> comments) {
        this.comments = comments;
    }

    public Set<PictureEntity> getPictures() {
        return pictures;
    }

    public void setPictures(Set<PictureEntity> pictures) {
        this.pictures = pictures;
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }
}
