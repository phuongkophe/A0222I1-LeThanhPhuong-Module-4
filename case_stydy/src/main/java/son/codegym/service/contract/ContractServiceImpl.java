package son.codegym.service.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import son.codegym.entity.Contract;
import son.codegym.repository.IContractRepo;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    IContractRepo contractRepo;

    @Override
    public Page<Contract> findAllWithPaging(Pageable pageable) {
        return contractRepo.findAll(pageable);
    }

    @Override
    public void create(Contract contract) {
        contractRepo.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepo.findAll();
    }
}
