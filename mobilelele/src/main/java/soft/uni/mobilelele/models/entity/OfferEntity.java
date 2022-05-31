package soft.uni.mobilelele.models.entity;

import soft.uni.mobilelele.models.enums.EngineEnum;
import soft.uni.mobilelele.models.enums.TransmissionEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity{

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private EngineEnum engine;

    @Column(name = "image_url")
    private String imageUrl;

    private int mileage;

    private BigDecimal price;

    private TransmissionEnum transmission;

    private int year;

    @ManyToOne
    private ModelEntity model;

    private UserEntity seller;
//    Create a Model class, which holds the following properties:


//•	created – a date and time.
//•	modified – a date and time.
//•	model – the model of a car.
//•	seller – a user that sells the car.
}
