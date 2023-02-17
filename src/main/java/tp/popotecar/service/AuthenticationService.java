package tp.popotecar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tp.popotecar.model.User;
import tp.popotecar.repository.UserRepository;
import tp.popotecar.service.dto.LoginDTO;
import tp.popotecar.service.dto.RegisterDTO;
import tp.popotecar.service.dto.UserDTO;
import tp.popotecar.service.mapper.RegisterMapper;
import tp.popotecar.service.mapper.UserMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final RegisterMapper registerMapper;

    private final UserMapper userMapper;

    public UserDTO register(RegisterDTO userRegister) {
        User user = registerMapper.toEntity(userRegister);
        user.setPassword(passwordEncoder.encode(userRegister.getPassword()));
        UserDTO userDTO = userMapper.toDto(repository.save(user));
        String jwtToken = jwtService.generateToken(user);
        userDTO.setToken(jwtToken);
        return userDTO;
    }

    public UserDTO login(LoginDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Optional<User> user = repository.findByEmail(request.getEmail());
        if (user.isPresent()) {
            String jwtToken = jwtService.generateToken(user.get());
            UserDTO userDTO = userMapper.toDto(user.get());
            userDTO.setToken(jwtToken);
            return userDTO;
        }

        return null;
    }
}