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
import tp.popotecar.repository.specification.RideSpecification;
import tp.popotecar.service.dto.RideCreateDTO;
import tp.popotecar.service.dto.RideDTO;
import tp.popotecar.service.dto.StepCreateDTO;
import tp.popotecar.service.dto.StepDTO;
import tp.popotecar.service.dto.criteria.RideCriteria;
import tp.popotecar.service.mapper.RideMapper;

import java.time.LocalDate;
import java.util.List;
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

            for (StepCreateDTO stepDTO : rideCreateDTO.getSteps()) {
                stepDTO.setPosition(position);
                stepService.addStep(stepDTO, rideSaved);
                position++;
            }

            return getRideById(rideSaved.getId());
        }

        return null;
    }

    public RideDTO getRideById(Long id) {
        Optional<Ride> ride = rideRepository.findById(id);
        return ride.map(rideMapper::toDto).orElse(null);

    }

    public List<RideDTO> getRidesByCriteria(RideCriteria rideCriteria) {
        List<Ride> rides = rideRepository.findAll(RideSpecification.specificationFromCriteria(rideCriteria));
        return rideMapper.toDto(rides);
    }
}