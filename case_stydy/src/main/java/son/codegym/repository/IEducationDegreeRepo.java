package son.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.EducationDegree;

@Repository
public interface IEducationDegreeRepo extends JpaRepository<EducationDegree, Integer> {
}
