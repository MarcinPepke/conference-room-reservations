package mpepke.system.reservation.service;

import mpepke.system.reservation.controller.request.AddUserRequest;
import mpepke.system.reservation.model.UserApp;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserService {
    UserApp saveUser(UserApp user);

    Optional<UserApp> loadByUsername(String username);

    UserApp addUser(AddUserRequest addUserRequest) throws Exception;
}
