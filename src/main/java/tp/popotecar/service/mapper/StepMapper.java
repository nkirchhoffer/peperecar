package tp.popotecar.service.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import tp.popotecar.model.Location;
import tp.popotecar.model.Step;
import tp.popotecar.service.dto.StepDTO;

@Mapper
public interface StepMapper extends EntityMapper<StepDTO, Step> {

    @BeforeMapping
    default void mapLocationToDTO(@MappingTarget StepDTO stepDTO, Step step) {
        Location location = step.getLocation();
        stepDTO.setAddress(location.getAddress());
        stepDTO.setCity(location.getCity());
        stepDTO.setZipCode(location.getZipCode());
        stepDTO.setCountry(location.getCountry());
    }

    @AfterMapping
    default void mapLocationToEntity(@MappingTarget Step step, StepDTO stepDTO) {
        Location location = new Location();
        location.setAddress(stepDTO.getAddress());
        location.setCity(stepDTO.getCity());
        location.setZipCode(stepDTO.getZipCode());
        location.setCountry(stepDTO.getCountry());
        step.setLocation(location);
    }


}
