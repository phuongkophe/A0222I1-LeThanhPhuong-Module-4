package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.RentType;

@Repository
public interface IRentTypeRepo extends JpaRepository<RentType, Integer> {
}
