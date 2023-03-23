package tp.popotecar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.popotecar.model.Ride;
import tp.popotecar.model.Step;
import tp.popotecar.model.City;
import tp.popotecar.repository.StepRepository;
import tp.popotecar.service.dto.StepCreateDTO;
import tp.popotecar.service.mapper.StepCreateMapper;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StepService {

    private final StepRepository stepRepository;

    private final StepCreateMapper stepCreateMapper;

    private final CityService cityService;
    public void addStep(StepCreateDTO stepCreateDTO, Ride ride) {
        Step step = stepCreateMapper.toEntity(stepCreateDTO);
        Optional<City> city = cityService.getById(stepCreateDTO.getCityId());
        if (city.isPresent()) {
            step.setCity(city.get());
            step.setRide(ride);
            stepRepository.save(step);
        }
    }
}
