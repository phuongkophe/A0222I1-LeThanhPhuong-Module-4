package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import son.codegym.entity.Contract;

public interface IContractRepo extends JpaRepository<Contract, Integer> {
}
