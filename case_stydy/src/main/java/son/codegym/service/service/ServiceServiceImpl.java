package son.codegym.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import son.codegym.entity.Service;
import son.codegym.repository.IServiceRepo;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    IServiceRepo serviceRepo;

    @Override
    public Page<Service> findAllWithPaging(Pageable pageable) {
        return serviceRepo.findAll(pageable);
    }

    @Override
    public void create(Service service) {
        serviceRepo.save(service);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepo.findAll();
    }
}
