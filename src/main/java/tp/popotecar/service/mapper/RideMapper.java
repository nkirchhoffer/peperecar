package tp.popotecar.service.mapper;

import org.mapstruct.Mapper;
import tp.popotecar.model.Ride;
import tp.popotecar.service.dto.RideDTO;

@Mapper(componentModel = "spring", uses = {StepMapper.class})
public interface RideMapper extends EntityMapper<RideDTO, Ride> {


    RideDTO toDto(Ride ride);
}
