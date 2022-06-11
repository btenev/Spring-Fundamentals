package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {

    @GetMapping("/users/login")
    private String login() {
        return "login";
    }
}
