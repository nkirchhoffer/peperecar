package tp.popotecar.service.mapper;

import org.mapstruct.Mapper;
import tp.popotecar.model.Step;
import tp.popotecar.service.dto.StepDTO;

@Mapper(componentModel = "spring")
public interface StepMapper extends EntityMapper<StepDTO, Step> {

}
