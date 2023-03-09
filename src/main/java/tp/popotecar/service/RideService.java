package tp.popotecar.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tp.popotecar.model.Ride;
import tp.popotecar.model.User;
import tp.popotecar.model.enumeration.Status;
import tp.popotecar.repository.RideRepository;
import tp.popotecar.service.dto.RideCreateDTO;
import tp.popotecar.service.dto.RideDTO;
import tp.popotecar.service.dto.StepDTO;
import tp.popotecar.service.mapper.RideMapper;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RideService {

    private static final Logger log = LoggerFactory.getLogger(RideService.class);

    private final RideRepository rideRepository;

    private final UserService userService;

    private final StepService stepService;

    private final RideMapper rideMapper;

    public RideDTO createRide(RideCreateDTO rideCreateDTO) {
        Optional<User> currentUser = userService.getConnectedUser();
        if (currentUser.isPresent()) {
            Ride ride = new Ride();
            ride.setMaxPassenger(rideCreateDTO.getMaxPassenger());
            ride.setCreationDate(LocalDate.now());
            ride.setDriver(currentUser.get());
            ride.setStatus(Status.BROUILLON);

            Ride rideSaved = rideRepository.save(ride);

            Long position = 1L;

            for (StepDTO stepDTO : rideCreateDTO.getSteps()) {
                stepDTO.setPosition(position);
                stepService.addStep(stepDTO, rideSaved);
                position++;
            }

            return rideMapper.toDto(
                    rideRepository.findById(rideSaved.getId()).get()
            );
        }

        return null;
    }

    public Ride getRideById(Long id) {
        return rideRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(""));
    }
}
