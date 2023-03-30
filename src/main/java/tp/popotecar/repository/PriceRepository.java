package tp.popotecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.popotecar.model.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
