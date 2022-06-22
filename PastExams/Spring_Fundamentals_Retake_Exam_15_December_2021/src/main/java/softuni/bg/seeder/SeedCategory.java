package softuni.bg.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.bg.model.entity.CategoryEntity;
import softuni.bg.model.enums.CategoryEnum;
import softuni.bg.repository.CategoryRepository;

import java.util.Arrays;

@Component
public class SeedCategory implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public SeedCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.categoryRepository.count() > 0) {
            return;
        }

        Arrays.stream(CategoryEnum.values())
                .forEach(categoryEnum -> {
                    CategoryEntity category = new CategoryEntity();
                    category.setName(categoryEnum);

                    this.categoryRepository.save(category);
                });
    }
}
