package tp.popotecar.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tp.popotecar.model.User;
import tp.popotecar.repository.UserRepository;
import tp.popotecar.service.dto.UserDTO;
import tp.popotecar.service.mapper.UserMapper;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public List<UserDTO> getAllUser() {
        return userMapper.toDto(userRepository.findAll());
    }

    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userMapper.toDto(user.get());
        }
        return null;
    }

    public void deleteById(Long id) {
        Boolean exist = userRepository.existsById(id);
        if (exist) {
            userRepository.deleteById(id);
            log.debug("The user with id {} has been deleted", id);
        } else {
            log.debug("The user with id {} does not exist", id);
        }

    }

    public Optional<User> getConnectedUser() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Principal::getName)
                .map(userRepository::findByEmail)
                .orElseGet(Optional::empty);
    }

    public UserDTO toDto(User user) {
        return userMapper.toDto(user);
    }
}
