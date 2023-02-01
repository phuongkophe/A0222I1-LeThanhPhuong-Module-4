package son.codegym.service.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import son.codegym.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    void create(Employee employee);
    void update(Employee employee);
    void delete(int id);
    List<Employee> findAll();
    Page <Employee> findAllAndSearch(String name,String position, String division, Pageable pageable);
    Employee findById(int id);
}
