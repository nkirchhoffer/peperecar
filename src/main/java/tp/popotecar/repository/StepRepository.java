package tp.popotecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.popotecar.model.Step;

public interface StepRepository extends JpaRepository<Step, Long> {
}
