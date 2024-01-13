package mpepke.system.reservation.service;

import mpepke.system.reservation.controller.request.AddLayoutRequest;
import mpepke.system.reservation.model.Layout;

public interface LayoutService {

    Layout addNewLayout(AddLayoutRequest request);
}
