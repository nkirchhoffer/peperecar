package tp.popotecar.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import tp.popotecar.model.Ride;
import tp.popotecar.model.enumeration.Status;
import tp.popotecar.service.dto.criteria.RideCriteria;

import java.time.LocalDate;

public class RideSpecification {

    public static Specification<Ride> specificationFromCriteria(RideCriteria rideCriteria) {
        if (rideCriteria == null) {
            return Specification.where(null);
        }

        return Specification
                .where(hasStatus(rideCriteria.getStatus()))
                .and(startDateBefore(rideCriteria.getBeforeDate()))
                .and(startDateAfter(rideCriteria.getAfterDate()));
    }

    private static Specification<Ride> hasStatus(Status status) {
        return (root, query, criteriaBuilder) ->
                status == null ? null : criteriaBuilder.equal(root.get("status"), status);
    }

    private static Specification<Ride> startDateBefore(LocalDate date) {
        return (root, query, criteriaBuilder) ->
                date == null ? null : criteriaBuilder.lessThan(root.get("startDate"), date);
    }

    private static Specification<Ride> startDateAfter(LocalDate date) {
        return (root, query, criteriaBuilder) ->
                date == null ? null : criteriaBuilder.greaterThan(root.get("startDate"), date);
    }

}
