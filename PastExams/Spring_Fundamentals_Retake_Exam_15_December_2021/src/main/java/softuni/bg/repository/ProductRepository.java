package softuni.bg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bg.model.entity.CategoryEntity;
import softuni.bg.model.entity.ProductEntity;
import softuni.bg.model.enums.CategoryEnum;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity>findByName(String name);

    @Query("SELECT SUM(p.price) FROM ProductEntity p")
    BigDecimal findTotalPrice();

    List<ProductEntity> findProductEntitiesByCategory_Name(CategoryEnum category_name);
}
