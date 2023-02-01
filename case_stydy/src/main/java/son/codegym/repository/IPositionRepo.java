package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Position;

@Repository
public interface IPositionRepo extends JpaRepository<Position, Integer> {
}
