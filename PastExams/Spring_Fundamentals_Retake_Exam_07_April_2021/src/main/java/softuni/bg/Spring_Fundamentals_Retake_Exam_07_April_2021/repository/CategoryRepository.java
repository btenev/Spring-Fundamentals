package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity.CategoryEntity;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity.NameEnum;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(NameEnum category);
}
