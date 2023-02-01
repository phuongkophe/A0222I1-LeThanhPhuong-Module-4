package son.codegym.service.customer_type;

import son.codegym.entity.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
