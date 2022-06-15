package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.service;

import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity.NameEnum;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {
    private long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private String description;
    private NameEnum category;
    private UserEntity userEntity;

    public OrderServiceModel() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NameEnum getCategory() {
        return category;
    }

    public void setCategory(NameEnum category) {
        this.category = category;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
