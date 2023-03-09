package tp.popotecar.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StepDTO {

    private LocalDate date;

    private Long position;

    private String address;

    private String zipCode;

    private String city;

    private String country;
}
