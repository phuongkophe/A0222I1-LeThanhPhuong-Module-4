package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.CustomerType;

@Repository
public interface ICustomerTypeRepo extends JpaRepository<CustomerType, Integer> {
}
