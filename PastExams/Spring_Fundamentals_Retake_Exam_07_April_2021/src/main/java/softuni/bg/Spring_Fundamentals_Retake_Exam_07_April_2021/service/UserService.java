package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.View.UserViewModel;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity.UserEntity;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.service.UserServiceModel;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.repository.UserRepository;
import softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.sec.CurrentUser;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;

        this.currentUser = currentUser;
    }

    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);

        this.userRepository.save(user);
    }

    public UserServiceModel findByUserNameAndPassword(String username, String password) {

        return this.userRepository
                .findByUsernameAndPassword(username, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    public void loginUser(long id, String username) {
        this.currentUser.setId(id);
        this.currentUser.setUsername(username);
    }

    public UserEntity findById(long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public List<UserViewModel> findByOrderCountDesc() {
        return this.userRepository.findAllByOrderByOrdersCountDesc();
    }
}
