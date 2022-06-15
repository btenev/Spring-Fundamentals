package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.binding.UserLoginBindingModel;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.service.UserServiceModel;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.sec.CurrentUser;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.service.UserService;

import javax.validation.Valid;

@Controller
public class UserLoginLogoutController {

    private final UserService userService;
    private final CurrentUser currentUser;

    public UserLoginLogoutController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;

        this.currentUser = currentUser;
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/users/login")
    private String login(Model model) {
        if (!model.containsAttribute("isFound")) {
            model.addAttribute("isFound", true);
        }

        return "login";
    }

    @PostMapping("/users/login")
    private String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);

            return "redirect:/users/login";
        }

        UserServiceModel userServiceModel = this.userService
                .findByUserNameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        if (userServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("isFound", false);

            return "redirect:/users/login";
        }

        this.userService.loginUser(userServiceModel.getId(), userServiceModel.getUsername());

        return "redirect:/";
    }

    @GetMapping("/users/logout")
    private String logout() {
        this.currentUser.clear();
        return "redirect:/";
    }
}
