package tp.popotecar.repository.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
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
                .and(hasCityIdsAndTimes(rideCriteria.getStartCityId(), rideCriteria.getEndCityId()));
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

    private static Specification<Ride> startDateBefore(LocalDate date) {
        return (root, query, criteriaBuilder) ->
                date == null ? null : criteriaBuilder.lessThan(root.get("startDate"), date);
    }

    private static Specification<Ride> startDateAfter(LocalDate date) {
        return (root, query, criteriaBuilder) ->
                date == null ? null : criteriaBuilder.greaterThan(root.get("startDate"), date);
    }

    public static Specification<Ride> hasCityIdsAndTimes(Long startCityId, Long endCityId) {
        return (root, query, criteriaBuilder) -> {
            Join<Ride, Step> stepJoin1 = root.join("steps");
            Join<Step, City> cityJoin1 = stepJoin1.join("city");

            Join<Ride, Step> stepJoin2 = root.join("steps");
            Join<Step, City> cityJoin2 = stepJoin2.join("city");

            Predicate cityIdPredicate = criteriaBuilder.and(
                    criteriaBuilder.equal(cityJoin1.get("id"), startCityId),
                    criteriaBuilder.equal(cityJoin2.get("id"), endCityId)
            );

            Predicate timePredicate = criteriaBuilder.lessThan(stepJoin1.get("time"), stepJoin2.get("time"));

            return criteriaBuilder.and(cityIdPredicate, timePredicate);
        };
    }

}
