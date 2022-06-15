package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.binding.OrderBindingModel;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.service.OrderServiceModel;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.service.OrderService;

import javax.validation.Valid;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public OrderBindingModel orderBindingModel() {
        return new OrderBindingModel();
    }

    @GetMapping("/orders/add")
    public String addOrder() {
        return "order-add";
    }

    @PostMapping("/orders/add")
    private String addOrderConfirm(@Valid OrderBindingModel orderBindingModel, BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("orderBindingModel", orderBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderBindingModel",
                            bindingResult);

            return "redirect:/orders/add";
        }

        this.orderService.addOrder(modelMapper.map(orderBindingModel, OrderServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/orders/ready/{id}")
    public String ready(@PathVariable long id) {
        this.orderService.readyOrderId(id);

        return "redirect:/";
    }
}
