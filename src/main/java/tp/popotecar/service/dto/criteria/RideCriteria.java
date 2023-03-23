package tp.popotecar.service.dto.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tp.popotecar.model.enumeration.Status;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RideCriteria {

    Status status;

    LocalDate beforeDate;

    LocalDate afterDate;

    Long startCityId;

    Long endCityId;

    Long nbPassenger;
}
