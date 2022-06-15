package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity.OrderEntity;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findAllByOrderByPriceDesc();
}
