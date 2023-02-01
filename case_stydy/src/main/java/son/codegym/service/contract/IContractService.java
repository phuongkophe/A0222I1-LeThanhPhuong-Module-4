package son.codegym.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import son.codegym.entity.Contract;

import java.util.List;

public interface IContractService {
    Page<Contract> findAllWithPaging(Pageable pageable);
    void create(Contract contract);
    List<Contract> findAll();
}
