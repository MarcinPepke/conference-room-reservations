package mpepke.system.reservation.repository;

import mpepke.system.reservation.model.Layout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LayoutRepository extends JpaRepository<Layout, Long> {

    Optional<Layout> findByType(String type);
}
