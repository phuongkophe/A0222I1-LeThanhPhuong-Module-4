package son.codegym.service.service_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.ServiceType;
import son.codegym.repository.IServiceTypeRepo;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    IServiceTypeRepo serviceTypeRepo;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepo.findAll();
    }
}
