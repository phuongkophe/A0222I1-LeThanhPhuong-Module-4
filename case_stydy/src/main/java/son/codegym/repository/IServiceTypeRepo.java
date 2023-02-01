package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.ServiceType;

@Repository
public interface IServiceTypeRepo extends JpaRepository<ServiceType, Integer> {
}
