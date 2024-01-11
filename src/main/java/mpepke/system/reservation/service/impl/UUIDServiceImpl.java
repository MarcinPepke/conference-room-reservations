package mpepke.system.reservation.service.impl;

import mpepke.system.reservation.service.UUIDService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDServiceImpl implements UUIDService {
    @Override
    public UUID randomUUID() {
        return UUID.randomUUID();
    }
}
