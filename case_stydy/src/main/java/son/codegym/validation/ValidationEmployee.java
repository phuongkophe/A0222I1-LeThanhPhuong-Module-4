package son.codegym.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import son.codegym.entity.Employee;

public class ValidationEmployee implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        if(employee.getEducationDegreeId() == null){
            errors.rejectValue("educationDegreeId","type");
        }

        if(employee.getPositionId() == null){
            errors.rejectValue("positionId","type");
        }

        if(employee.getDivisionId() == null){
            errors.rejectValue("divisionId","type");
        }
        if (employee.getEmployeeBirthday() == null){
            errors.rejectValue("employeeBirthday","type");
        }

    }
}
