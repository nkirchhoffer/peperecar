package tp.popotecar.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.popotecar.service.AuthenticationService;
import tp.popotecar.service.dto.LoginDTO;
import tp.popotecar.service.dto.RegisterDTO;
import tp.popotecar.service.dto.UserDTO;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(
            @RequestBody RegisterDTO userRegister
    ) {
        return ResponseEntity.ok(service.register(userRegister));
    }
    @PostMapping("/login")
    public ResponseEntity<UserDTO> authenticate(
            @RequestBody LoginDTO userLogin
    ) {
        return ResponseEntity.ok(service.login(userLogin));
    }


}
