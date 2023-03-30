package tp.popotecar.service.dto.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import tp.popotecar.model.enumeration.Status;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RideCriteria {

    @NotNull
    Status status;

    LocalDate date;

    LocalTime beforeTime;

    LocalTime afterTime;

    @NotNull
    Long startCityId;

    @NotNull
    Long endCityId;

    Long nbPassenger;
}
