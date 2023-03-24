package tp.popotecar.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tp.popotecar.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

    Page<City> findByNameStartingWithIgnoreCase(String name, Pageable pageable);
}
