package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.service;

import org.springframework.stereotype.Service;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity.CategoryEntity;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity.NameEnum;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.repository.CategoryRepository;

import java.util.Arrays;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void initCategory() {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(NameEnum.values())
                .forEach(nameEnum -> {
                    CategoryEntity category = new CategoryEntity();

                    category.setName(nameEnum);

                    switch (nameEnum) {
                        case DRINK -> category.setNeededTime(1);
                        case COFFEE -> category.setNeededTime(2);
                        case OTHER -> category.setNeededTime(5);
                        case CAKE -> category.setNeededTime(10);
                    }

                    this.categoryRepository.save(category);
                });
    }

    public CategoryEntity findByNameEnum(NameEnum category) {
        return this.categoryRepository.findByName(category).orElse(null);
    }
}
