package tp.popotecar.service.mapper;

import org.mapstruct.Mapper;
import tp.popotecar.model.Step;
import tp.popotecar.service.dto.StepCreateDTO;

@Mapper
public interface StepCreateMapper extends EntityMapper<StepCreateDTO, Step> {

}
