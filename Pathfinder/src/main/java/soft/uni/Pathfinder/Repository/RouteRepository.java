package soft.uni.Pathfinder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import soft.uni.Pathfinder.model.entity.RouteEntity;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
    @Query("SELECT r FROM RouteEntity r ORDER BY size(r.comments) DESC")
    List<RouteEntity> findFirstByMostCommented();
}
