package son.codegym.service.education;

import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.EducationDegree;
import son.codegym.repository.IEducationDegreeRepo;

import java.util.List;

@Service
public class EducationServiceImpl implements IEducationService{
    @Autowired
    IEducationDegreeRepo educationDegreeRepo;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepo.findAll();
    }
}
