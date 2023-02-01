package son.codegym.service.postion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.Position;
import son.codegym.repository.IPositionRepo;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    IPositionRepo positionRepo;
    public List<Position> findAll() {
        return positionRepo.findAll();
    }
}
