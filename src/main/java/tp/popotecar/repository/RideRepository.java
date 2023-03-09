package tp.popotecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.popotecar.model.Ride;

public interface RideRepository extends JpaRepository<Ride, Long> {
}
