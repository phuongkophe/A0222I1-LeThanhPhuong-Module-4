package son.codegym.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import son.codegym.entity.Contract;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class ValidationContract implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;

        if (contract.getContractStartDate() == null) {
            errors.rejectValue("contractStartDate", "type");
        }
        if (contract.getContractEndDate() == null) {
            errors.rejectValue("contractEndDate", "type");
        }

        if (!(contract.getContractStartDate() == null) && !(contract.getContractEndDate() == null)) {
            LocalDate startTime = contract.getContractStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endTime = contract.getContractEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(startTime, endTime).getDays() < 0) {
                errors.rejectValue("contractEndDate", "dateComparison");
            }
        }
        if (contract.getCustomerId() == null) {
            errors.rejectValue("customerId", "type");
        }
        if (contract.getEmployeeId() == null) {
            errors.rejectValue("employeeId", "type");
        }
        if (contract.getServiceId() == null) {
            errors.rejectValue("serviceId", "type");
        }
    }
}
