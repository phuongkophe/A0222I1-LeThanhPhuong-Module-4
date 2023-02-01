package son.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import son.codegym.entity.Customer;
import son.codegym.entity.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

    @Query(value="SELECT * FROM employee where employee_name like :nameSearch and position_id like :positionSearch and division_id like:divisionSearch ",
            nativeQuery = true)
    Page<Employee> findAllAndSearch(@Param("nameSearch")String nameSearch, @Param("positionSearch") String position, @Param("divisionSearch") String division, Pageable pageable);
}

