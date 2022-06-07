package soft.uni.mobilelele.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import soft.uni.mobilelele.models.dto.UserLoginDTO;
import soft.uni.mobilelele.models.dto.UserRegisterDTO;
import soft.uni.mobilelele.models.entity.UserEntity;
import soft.uni.mobilelele.repository.UserRepository;
import soft.uni.mobilelele.user.CurrentUser;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public void RegisterAndLogin(UserRegisterDTO userRegisterDTO) {
        UserEntity newUser =
                new UserEntity()
                        .setActive(true)
                        .setEmail(userRegisterDTO.getEmail())
                        .setFirstName(userRegisterDTO.getFirstName())
                        .setLastName(userRegisterDTO.getLastName())
                        .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

       newUser = this.userRepository.save(newUser);

       login(newUser);
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> userOpt = this.userRepository.findByEmail(userLoginDTO.getUsername());

        if (userOpt.isEmpty()) {
            LOGGER.info("User with name [{}] not found.", userLoginDTO.getUsername());
            return false;
        }

        String rawPassword = userLoginDTO.getPassword();
        String encodedPassword = userOpt.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            login(userOpt.get());
        } else {
            logout();
        }

        return success;
    }

    private void login(UserEntity userEntity) {
        this.currentUser
                .setLoggedIn(true)
                .setName(userEntity.getFirstName() + " " + userEntity.getLastName());
    }

    public void logout() {
        this.currentUser
                .clear();
    }
}
