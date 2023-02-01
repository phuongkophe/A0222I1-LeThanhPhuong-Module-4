package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Service;

@Repository
public interface IServiceRepo extends JpaRepository<Service, String> {
}
