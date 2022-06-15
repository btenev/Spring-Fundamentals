package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.View;

import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity.CategoryEntity;

import java.math.BigDecimal;

public class OrderViewModel {
    private long id;
    private String name;
    private BigDecimal price;
    private CategoryEntity category;

    public OrderViewModel() {
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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
