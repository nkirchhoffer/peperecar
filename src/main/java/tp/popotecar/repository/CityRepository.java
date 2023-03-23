package tp.popotecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.popotecar.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
