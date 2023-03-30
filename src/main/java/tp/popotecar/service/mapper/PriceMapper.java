package tp.popotecar.service.mapper;

import org.mapstruct.Mapper;
import tp.popotecar.model.Price;
import tp.popotecar.service.dto.PriceDTO;

@Mapper
public interface PriceMapper extends EntityMapper<PriceDTO, Price> {

}
