package tp.popotecar.web.rest;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.popotecar.model.City;
import tp.popotecar.service.CityService;
import tp.popotecar.service.RideService;
import tp.popotecar.service.dto.RideCreateDTO;
import tp.popotecar.service.dto.RideDTO;
import tp.popotecar.service.dto.criteria.RideCriteria;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private static final Logger log = LoggerFactory.getLogger(CityController.class);

    private final CityService cityService;

    @GetMapping("")
    public ResponseEntity<List<City>> searchCity(
            @RequestParam final String name,
            @RequestParam(required = false, defaultValue = "5") final int size
            ) {

        Page<City> citiesPage = cityService.getCitiesByName(name, size);
        return ResponseEntity.ok(citiesPage.get().toList());
    }
}
