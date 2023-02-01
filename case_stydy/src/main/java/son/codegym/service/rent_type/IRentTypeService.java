package son.codegym.service.rent_type;

import son.codegym.entity.CustomerType;
import son.codegym.entity.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
}
