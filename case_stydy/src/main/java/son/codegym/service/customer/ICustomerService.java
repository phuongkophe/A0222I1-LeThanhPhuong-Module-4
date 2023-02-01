package son.codegym.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import son.codegym.entity.Customer;

import java.util.List;

public interface ICustomerService {
    void create(Customer customer);
    void update(Customer customer);
    void delete(String id);
    List<Customer> findAll();
    Customer findById(String id);
    Page<Customer> findAllWithPaging(Pageable pageable);
    Page<Customer> search(String name,String email, int customerTypeId, Pageable pageable);
    Page<Customer> searchNameTypeCustomer(String name,String email, String customerTypeId, Pageable pageable);
}
