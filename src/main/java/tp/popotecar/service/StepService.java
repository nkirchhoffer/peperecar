package tp.popotecar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.popotecar.model.Location;
import tp.popotecar.model.Ride;
import tp.popotecar.model.Step;
import tp.popotecar.repository.LocationRepository;
import tp.popotecar.repository.StepRepository;
import tp.popotecar.service.dto.StepDTO;
import tp.popotecar.service.mapper.StepMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StepService {

    private final StepRepository stepRepository;

    private final LocationRepository locationRepository;

    private final StepMapper stepMapper;

    public void addStep(StepDTO stepDTO, Ride ride) {
        Step step = stepMapper.toEntity(stepDTO);
        Location location = locationRepository.save(step.getLocation());
        step.setLocation(location);
        step.setRide(ride);
        stepRepository.save(step);
    }
}
