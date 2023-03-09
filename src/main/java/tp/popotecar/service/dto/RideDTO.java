package tp.popotecar.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RideDTO {

    private Long id;

    private Long maxPassenger;

    private LocalDate creationDate;

    private String status;

    private UserDTO driver;

    private List<StepDTO> steps;
}
