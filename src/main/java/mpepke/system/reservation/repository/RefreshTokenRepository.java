package mpepke.system.reservation.repository;

import mpepke.system.reservation.model.RefreshToken;
import mpepke.system.reservation.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByToken(String token);
    Optional<RefreshToken> findByUser(UserApp user);
}
