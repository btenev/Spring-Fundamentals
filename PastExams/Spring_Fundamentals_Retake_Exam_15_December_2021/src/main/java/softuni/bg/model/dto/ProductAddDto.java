package softuni.bg.model.dto;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.bg.model.entity.CategoryEntity;
import softuni.bg.model.enums.CategoryEnum;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddDto {

    @NotBlank
    @Size(min=3, max = 20, message = "Name length must be between 3 and 20 characters!")
    private String name;
    @NotBlank
    @Size(min=5, message = "Description min length must be minimum 5!")
    private String description;

    @NotNull
    @Positive(message = "Price must be positive!")
    private BigDecimal price;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "Date cannot be in the past!")
    private LocalDateTime neededBefore;

    @NotNull(message = "You must select a category")
    private CategoryEnum category;

    public ProductAddDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
