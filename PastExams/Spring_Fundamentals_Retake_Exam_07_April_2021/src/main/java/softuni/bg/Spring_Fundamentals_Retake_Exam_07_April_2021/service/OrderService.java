package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.View.OrderViewModel;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity.OrderEntity;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.service.OrderServiceModel;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.repository.OrderRepository;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.sec.CurrentUser;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;


    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser,
                        UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    public void addOrder(OrderServiceModel orderServiceModel) {
        OrderEntity orderEntity = this.modelMapper.map(orderServiceModel, OrderEntity.class);
        orderEntity.setEmployee(this.userService.findById(this.currentUser.getId()));
        orderEntity.setCategory(this.categoryService.findByNameEnum(orderServiceModel.getCategory()));

        this.orderRepository.save(orderEntity);
    }


    public List<OrderViewModel> findAllOrderByPriceDesc() {
        List<OrderEntity> orderEntities = this.orderRepository.findAllByOrderByPriceDesc();

        return orderEntities
                .stream()
                .map(orderEntity -> modelMapper.map(orderEntity, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    public void readyOrderId(long id) {
        this.orderRepository.deleteById(id);
    }
}
