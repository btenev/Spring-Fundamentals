package soft.uni.Pathfinder.Service;

import org.springframework.stereotype.Service;
import soft.uni.Pathfinder.Repository.RouteRepository;
import soft.uni.Pathfinder.model.entity.RouteEntity;

@Service
public class RouteService {
    private final RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    public RouteEntity getMostCommented() {
        return this.repository.findFirstByMostCommented().get(0);
    }
}
