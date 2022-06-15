package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.binding;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity.NameEnum;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderBindingModel {

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @Positive
    private BigDecimal price;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime orderTime;

    @NotNull
    private NameEnum category;

    @Size(min = 5)
    private String description;

    public OrderBindingModel() {
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

    public NameEnum getCategory() {
        return category;
    }

    public void setCategory(NameEnum category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
