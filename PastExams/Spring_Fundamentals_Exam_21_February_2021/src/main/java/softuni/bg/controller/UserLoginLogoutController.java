package softuni.bg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.model.dto.UserLoginDto;
import softuni.bg.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserLoginLogoutController {

    private final UserService userService;

    public UserLoginLogoutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("userLoginDto")) {
            model.addAttribute("userLoginDto", new UserLoginDto());
            model.addAttribute("invalidUser", false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginDto userLoginDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginDto", userLoginDto);

            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginDto",
                            bindingResult);

            return "redirect:login";
        }

        if (!this.userService.login(userLoginDto)) {
            redirectAttributes
                    .addFlashAttribute("userLoginDto", userLoginDto);

            redirectAttributes
                    .addFlashAttribute("invalidUser", true);

            return "redirect:login";
        }

        return "redirect:/";
    }
}
