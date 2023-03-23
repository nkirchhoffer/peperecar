package tp.popotecar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.popotecar.model.City;
import tp.popotecar.repository.CityRepository;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public Optional<City> getById(Long id) {
        return cityRepository.findById(id);
    }
}
