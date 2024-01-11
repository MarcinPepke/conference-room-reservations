package mpepke.system.reservation.repository;

import mpepke.system.reservation.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {

    UserApp findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<UserApp> findByUsernameIgnoreCase(String username);
}
