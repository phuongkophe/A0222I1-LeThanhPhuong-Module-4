package son.codegym.service.division;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.Division;
import son.codegym.repository.IDivisionRepo;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService{
    @Autowired
    IDivisionRepo divisionRepo;

    @Override
    public List<Division> findAll() {
        return divisionRepo.findAll();
    }
}
