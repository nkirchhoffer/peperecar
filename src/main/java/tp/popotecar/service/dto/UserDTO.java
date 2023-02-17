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
public class UserDTO {

    private String firstname;
    private String name;
    private String email;

    private String phone;

    private LocalDate birthDate;

    private String token;
}
