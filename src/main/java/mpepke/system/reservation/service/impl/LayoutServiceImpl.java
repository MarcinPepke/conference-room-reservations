package mpepke.system.reservation.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mpepke.system.reservation.controller.request.AddLayoutRequest;
import mpepke.system.reservation.model.Layout;
import mpepke.system.reservation.repository.LayoutRepository;
import mpepke.system.reservation.service.LayoutService;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class LayoutServiceImpl implements LayoutService {

    private final LayoutRepository repository;

    @Override
    public Layout addNewLayout(AddLayoutRequest request) {
        Layout layoutToAdd = new Layout();
        layoutToAdd.setType(layoutToAdd.getType());
        return repository.save(layoutToAdd);
    }
}
