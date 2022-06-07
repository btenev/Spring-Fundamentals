package soft.uni.mobilelele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import soft.uni.mobilelele.models.dto.UserRegisterDTO;
import soft.uni.mobilelele.service.UserService;

@Controller
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("users/register")
    public String register(UserRegisterDTO userRegisterDTO) {
        this.userService.RegisterAndLogin(userRegisterDTO);
        return "redirect:/";
    }
}
