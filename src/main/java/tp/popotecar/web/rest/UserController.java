package tp.popotecar.web.rest;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.popotecar.model.User;
import tp.popotecar.service.UserService;
import tp.popotecar.service.dto.UserDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    /**
     * Get the list of users
     * @return list of users
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser(
    ) {
        log.debug("Request for get the list of users");
        return ResponseEntity.ok(userService.getAllUser());
    }

    /**
     * Search a user by id
     * @param id user id
     * @return the user found
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(
            @PathVariable Long id
    ) {
        log.debug("Request for search a user by id : {}", id);
        return ResponseEntity.ok(userService.getUserById(id));
    }

    /**
     * Delete a user by id
     * @param id user id
     * @return empty
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id
    ) {
        log.debug("Request for delete a user by id : {}", id);
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Get the current user
     * @return The current user
     */
    @GetMapping("/current")
    public ResponseEntity<UserDTO> getCurrentUser() {
        log.debug("Resquest for get the current user");
        Optional<User> user = userService.getConnectedUser();
        if (user.isPresent()) {
            return ResponseEntity.ok(userService.toDto(user.get()));
        }
        log.debug("No current user found");
        return ResponseEntity.notFound().build();
    }
    
}
