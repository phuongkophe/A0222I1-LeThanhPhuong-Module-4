package son.codegym.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import son.codegym.entity.Customer;
import son.codegym.repository.ICustomerRepo;

import java.util.List;

@Service
public class CustomerServiceImpl implements  ICustomerService{
    @Autowired
    ICustomerRepo customerRepo;

    @Override
    public void create(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void delete(String id) {
        customerRepo.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(String id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findAllWithPaging(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public Page<Customer> search(String name, String email, int customerTypeId, Pageable pageable) {
        return customerRepo.findAllByCustomerNameContainingAndCustomerEmailContainingAndCustomerTypeId_CustomerTypeIdOrderByCustomerEmail(name,email,customerTypeId,pageable);
    }

    @Override
    public Page<Customer> searchNameTypeCustomer(String name, String email, String customerTypeId, Pageable pageable) {
        return customerRepo.findAllByCustomerNameContainingAndCustomerEmailContainingAndCustomerTypeId_CustomerTypeNameContainingOrderByCustomerEmail(name,email,customerTypeId,pageable);
    }


}
