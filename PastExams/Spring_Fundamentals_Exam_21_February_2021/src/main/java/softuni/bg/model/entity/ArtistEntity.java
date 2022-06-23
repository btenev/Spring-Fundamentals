package softuni.bg.model.entity;

import softuni.bg.model.enums.BandNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class ArtistEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BandNameEnum name;

    @Column(columnDefinition = "TEXT")
    private String careerInformation;

    public ArtistEntity() {
    }

    public BandNameEnum getName() {
        return name;
    }

    public void setName(BandNameEnum name) {
        this.name = name;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
