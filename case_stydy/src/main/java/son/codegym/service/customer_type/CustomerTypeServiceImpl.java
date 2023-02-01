package son.codegym.service.customer_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.CustomerType;
import son.codegym.repository.ICustomerTypeRepo;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService{
    @Autowired
    ICustomerTypeRepo customerTypeRepo;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepo.findAll();
    }
}
