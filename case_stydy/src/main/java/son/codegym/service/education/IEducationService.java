package son.codegym.service.education;

import son.codegym.entity.EducationDegree;

import java.util.List;

public interface IEducationService {
    List<EducationDegree> findAll();
}
