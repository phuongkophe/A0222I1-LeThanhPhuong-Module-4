package son.codegym.service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import son.codegym.entity.Service;

import java.util.List;

public interface IServiceService {
    Page<Service> findAllWithPaging(Pageable pageable);
    void create(Service service);
    List<Service> findAll();
}
