package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.View.OrderViewModel;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.View.UserViewModel;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.sec.CurrentUser;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.service.OrderService;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.service.UserService;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.getId() == 0) {
            return "index";
        }

        List<OrderViewModel> orderList = orderService.findAllOrderByPriceDesc();

        model.addAttribute("orders", orderList);

        int sumOfOrderTime = orderList
                .stream()
                .mapToInt(orderViewModel -> orderViewModel.getCategory().getNeededTime())
                .sum();

        model.addAttribute("orderTime", sumOfOrderTime);

        List<UserViewModel> orderCountDesc = this.userService.findByOrderCountDesc();

        model.addAttribute("userByOrdersDesc", orderCountDesc);

        return "home";
    }
}
