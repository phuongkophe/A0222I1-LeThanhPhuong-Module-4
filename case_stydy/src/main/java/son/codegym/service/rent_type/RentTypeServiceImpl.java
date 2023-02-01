package son.codegym.service.rent_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.RentType;
import son.codegym.repository.IRentTypeRepo;

import java.util.List;

@Service
public class RentTypeServiceImpl implements IRentTypeService {

    @Autowired
    IRentTypeRepo rentTypeRepo;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepo.findAll();
    }
}
