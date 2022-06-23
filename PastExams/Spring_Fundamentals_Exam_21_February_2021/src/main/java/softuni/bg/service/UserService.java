package softuni.bg.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.bg.model.dto.UserLoginDto;
import softuni.bg.model.dto.UserRegistrationDto;
import softuni.bg.model.entity.UserEntity;
import softuni.bg.repository.UserRepository;
import softuni.bg.session.CurrentUser;

import java.util.Optional;

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

    public boolean register(UserRegistrationDto userRegistrationDto) {
        Optional<UserEntity> byEmail = this.userRepository.findByEmail(userRegistrationDto.getEmail());

        if (byEmail.isPresent()) {
            return false;
        }

        Optional<UserEntity> byUsername = this.userRepository.findByUsername(userRegistrationDto.getUsername());

        if (byUsername.isPresent()) {
            return false;
        }

        UserEntity user = this.modelMapper.map(userRegistrationDto, UserEntity.class);

        this.userRepository.save(user);

        return true;
    }

    public boolean login(UserLoginDto userLoginDto) {
        Optional<UserEntity> byUsernameAndPassword =
                this.userRepository.findByUsernameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());

        if (byUsernameAndPassword.isEmpty()) {
            return false;
        }

        this.currentUser.login(byUsernameAndPassword.get());

        return true;
    }
}
