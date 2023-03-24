package tp.popotecar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<City> getCitiesByName(String name, int size) {
        return cityRepository.findByNameStartingWithIgnoreCase(name, PageRequest.of(0, size));
    }
}
