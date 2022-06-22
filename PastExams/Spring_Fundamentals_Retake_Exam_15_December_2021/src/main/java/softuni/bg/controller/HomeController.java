package softuni.bg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.bg.model.enums.CategoryEnum;
import softuni.bg.service.ProductService;
import softuni.bg.user.CurrentUser;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final ProductService productService;

    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("totalSum",
                this.productService.sumOfAllProducts());
        model.addAttribute("drinks",
                this.productService.findAllProductsByCategoryName(CategoryEnum.DRINK));
        model.addAttribute("food",
                this.productService.findAllProductsByCategoryName(CategoryEnum.FOOD));
        model.addAttribute("household",
                this.productService.findAllProductsByCategoryName(CategoryEnum.HOUSEHOLD));
        model.addAttribute("other",
                this.productService.findAllProductsByCategoryName(CategoryEnum.OTHER));

        return "home";
    }


}
