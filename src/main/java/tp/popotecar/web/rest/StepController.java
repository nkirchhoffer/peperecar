package tp.popotecar.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.popotecar.service.RideService;
import tp.popotecar.service.StepService;
import tp.popotecar.service.dto.StepCreateDTO;

@RestController
@RequestMapping("/api/steps")
@RequiredArgsConstructor
public class StepController {

    private final RideService rideService;

    private final StepService stepService;

    @PostMapping("/{rideId}")
    public ResponseEntity<Void> addStep(
            @RequestBody StepCreateDTO stepCreateDTO,
            @PathVariable(value = "rideId") final Long rideId
    ) {
        rideService.getRideById(rideId).ifPresent(ride -> stepService.addStep(stepCreateDTO, ride));
        return ResponseEntity.ok().build();
    }
}
