package tp.popotecar.repository.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.domain.Specification;
import tp.popotecar.model.Ride;
import tp.popotecar.model.Step;
import tp.popotecar.model.City;
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
                .and(hasDate(rideCriteria.getDate()))
                .and(hasCityIdsAndPositions(rideCriteria.getStartCityId(), rideCriteria.getEndCityId()));
    }

    private static Specification<Ride> hasStatus(Status status) {
        return (root, query, criteriaBuilder) ->
                status == null ? null : criteriaBuilder.equal(root.get("status"), status);
    }

    private static Specification<Ride> hasDate(LocalDate date) {
        return (root, query, criteriaBuilder) -> {
            if (date == null) return null;
            Join<Ride, Step> stepJoin = root.join("steps");
            return criteriaBuilder.equal(stepJoin.get("date"), date);
        };
    }

    public static Specification<Ride> hasCityIdsAndPositions(Long startCityId, Long endCityId) {
        return (root, query, builder) -> {
            Join<Ride, Step> stepJoin1 = root.join("steps");
            Join<Step, City> cityJoin1 = stepJoin1.join("city");

            Join<Ride, Step> stepJoin2 = root.join("steps");
            Join<Step, City> cityJoin2 = stepJoin2.join("city");

            Predicate cityIdPredicate = builder.and(
                    builder.equal(cityJoin1.get("id"), startCityId),
                    builder.equal(cityJoin2.get("id"), endCityId)
            );

            Predicate positionPredicate = builder.lessThan(stepJoin1.get("position"), stepJoin2.get("position"));

            return builder.and(cityIdPredicate, positionPredicate);
        };
    }

}
