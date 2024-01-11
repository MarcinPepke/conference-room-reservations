package mpepke.system.reservation.service;

import mpepke.system.reservation.model.RefreshToken;
import mpepke.system.reservation.model.UserApp;

import java.util.Optional;

public interface RefreshTokenService {
    Optional<RefreshToken> findByUser(UserApp user);

    RefreshToken save(RefreshToken refreshToken);

    Optional<RefreshToken> findByToken(String token);

    void deleteToken(RefreshToken refreshToken);
}
