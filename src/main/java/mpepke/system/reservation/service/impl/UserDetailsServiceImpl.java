package mpepke.system.reservation.service.impl;

import lombok.AllArgsConstructor;
import mpepke.system.reservation.model.UserApp;
import mpepke.system.reservation.repository.UserAppRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserAppRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserApp user = userRepository.findByUsername(username);

        return User
                .withUsername(username)
                .password(user.getPassword())
                .authorities(user.getRole())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
