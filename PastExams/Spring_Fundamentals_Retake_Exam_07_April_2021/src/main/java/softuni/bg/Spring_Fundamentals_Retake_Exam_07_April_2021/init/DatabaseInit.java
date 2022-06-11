package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.service.CategoryService;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final CategoryService categoryService;

    public DatabaseInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.initCategory();
    }
}
