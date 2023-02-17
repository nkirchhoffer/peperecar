package tp.popotecar.service.mapper;

import org.mapstruct.Mapper;
import tp.popotecar.model.User;
import tp.popotecar.service.dto.RegisterDTO;

@Mapper
public interface RegisterMapper extends EntityMapper<RegisterDTO, User> {
}
