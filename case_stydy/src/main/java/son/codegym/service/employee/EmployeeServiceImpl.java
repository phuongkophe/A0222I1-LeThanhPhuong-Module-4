package son.codegym.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import son.codegym.entity.Employee;
import son.codegym.repository.IEmployeeRepo;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    IEmployeeRepo employeeRepo;

    @Override
    public void create(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Page<Employee> findAllAndSearch(String name, String position, String division, Pageable pageable) {
        return employeeRepo.findAllAndSearch("%"+name+"%","%"+position+"%","%"+division+"%", pageable);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepo.findById(id).orElse(null);
    }
}
