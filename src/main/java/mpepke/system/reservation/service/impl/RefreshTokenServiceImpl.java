package mpepke.system.reservation.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mpepke.system.reservation.model.RefreshToken;
import mpepke.system.reservation.model.UserApp;
import mpepke.system.reservation.repository.RefreshTokenRepository;
import mpepke.system.reservation.service.RefreshTokenService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository repository;

    @Override
    public Optional<RefreshToken> findByUser(UserApp user) {
        return repository.findByUser(user);
    }

    @Override
    public RefreshToken save(RefreshToken refreshToken) {
        return repository.save(refreshToken);
    }

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return repository.findByToken(token);
    }

    @Override
    public void deleteToken(RefreshToken refreshToken) {
        repository.delete(refreshToken);
    }
}
