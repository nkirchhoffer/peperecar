package tp.popotecar.web.rest;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.popotecar.service.RideService;
import tp.popotecar.service.dto.RideCreateDTO;
import tp.popotecar.service.dto.RideDTO;

@RestController
@RequestMapping("/api/rides")
@RequiredArgsConstructor
public class RideController {

    private static final Logger log = LoggerFactory.getLogger(RideController.class);

    private final RideService rideService;

    @PostMapping
    public ResponseEntity<RideDTO> createRide(
            @RequestBody RideCreateDTO rideCreateDTO
            ) {
        return ResponseEntity.ok(rideService.createRide(rideCreateDTO));
    }
}
