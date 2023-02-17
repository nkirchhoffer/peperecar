package tp.popotecar.service.mapper;

import org.mapstruct.Mapper;
import tp.popotecar.model.User;
import tp.popotecar.service.dto.UserDTO;

@Mapper
public interface UserMapper extends EntityMapper<UserDTO, User> {
}
