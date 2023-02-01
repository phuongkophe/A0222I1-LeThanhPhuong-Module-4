package son.codegym.service.service_type;

import org.springframework.stereotype.Service;
import son.codegym.entity.RentType;
import son.codegym.entity.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();
}
