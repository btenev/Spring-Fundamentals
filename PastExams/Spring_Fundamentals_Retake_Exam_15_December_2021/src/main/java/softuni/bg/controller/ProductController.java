package softuni.bg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.model.dto.ProductAddDto;
import softuni.bg.service.ProductService;
import softuni.bg.user.CurrentUser;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final CurrentUser currentUser;

    public ProductController(ProductService productService, CurrentUser currentUser) {
        this.productService = productService;
        this.currentUser = currentUser;
    }

    @ModelAttribute("productAddDto")
    public ProductAddDto productAddDto() {
        return new ProductAddDto();
    }

    @GetMapping("/add")
    public String addProduct() {
        if (currentUser.getId() == null) {
            return "redirect:/users/login";
        }

        return "product-add";
    }

    @PostMapping("/add")
    public String addProductConfirm(@Valid ProductAddDto productAddDto, BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.productService.addProduct(productAddDto)) {
            redirectAttributes
                    .addFlashAttribute("productAddDto", productAddDto);

            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.productAddDto",
                            bindingResult);

            return "redirect:add";
        }


        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buyById(@PathVariable long id) {
        this.productService.removeProduct(id);
        return "redirect:/";
    }

    @GetMapping("/buy/all")
    public String buyAll() {
        this.productService.removeAllProducts();
        return "redirect:/";
    }
}
