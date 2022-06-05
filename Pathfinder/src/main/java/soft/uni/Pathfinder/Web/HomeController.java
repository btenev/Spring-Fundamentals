package soft.uni.Pathfinder.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import soft.uni.Pathfinder.Service.RouteService;
import soft.uni.Pathfinder.model.entity.RouteEntity;

@Controller
public class HomeController {

    private final RouteService routeService;

    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        RouteEntity route = routeService.getMostCommented();

        model.addAttribute("mostCommented", route);

        return "index";
    }
}
