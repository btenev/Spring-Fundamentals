package softuni.bg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.model.entity.ArtistEntity;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {
}
