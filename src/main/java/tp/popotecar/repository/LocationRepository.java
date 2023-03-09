package tp.popotecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.popotecar.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
