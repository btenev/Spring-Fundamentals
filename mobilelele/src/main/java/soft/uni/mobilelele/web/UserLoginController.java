package soft.uni.mobilelele.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import soft.uni.mobilelele.models.dto.UserLoginDTO;
import soft.uni.mobilelele.service.UserService;

@Controller
public class UserLoginController {

    private final UserService userService;

    @Autowired
    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return"auth-login";
    }

    @GetMapping("/users/logout")
    public String logout() {
        this.userService.logout();
        return "redirect:/";
    }

    @PostMapping("/users/login")
    public String login(UserLoginDTO userLoginDTO) {
        this.userService.login(userLoginDTO);
        return "redirect:/";
    }
}
