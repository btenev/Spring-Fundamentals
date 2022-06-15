package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.View.UserViewModel;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    @Query("SELECT" +
            " new softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.View.UserViewModel(u.username, size(u.orders))" +
            " FROM UserEntity u ORDER BY size(u.orders) DESC")
    List<UserViewModel> findAllByOrderByOrdersCountDesc();
}
