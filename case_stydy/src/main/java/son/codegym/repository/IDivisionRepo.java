package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Division;

@Repository
public interface IDivisionRepo extends JpaRepository<Division, Integer> {
}
