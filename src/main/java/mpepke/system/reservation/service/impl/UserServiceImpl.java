package mpepke.system.reservation.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mpepke.system.reservation.controller.request.AddUserRequest;
import mpepke.system.reservation.model.UserApp;
import mpepke.system.reservation.repository.UserAppRepository;
import mpepke.system.reservation.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserAppRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public UserApp saveUser(UserApp user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserApp> loadByUsername(String username) {
        return userRepository.findByUsernameIgnoreCase(username);
    }

    @Override
    public UserApp addUser(AddUserRequest addUserRequest) throws Exception {
        Optional<UserApp> loaded = userRepository.findByUsernameIgnoreCase(addUserRequest.getUsername());
        if (loaded.isPresent())
            throw new Exception();
        else {
            return saveUser(UserApp.builder()
                    .username(addUserRequest.getUsername())
                    .active(addUserRequest.isActive())
                    .password(passwordEncoder.encode(addUserRequest.getPassword()))
                    .role(addUserRequest.getRole())
                    .build());
        }
    }
}
