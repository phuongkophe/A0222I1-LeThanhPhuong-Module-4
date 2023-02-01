package son.codegym.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import son.codegym.entity.Customer;

public class ValidationCustomer implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer =(Customer) target;

        if(customer.getCustomerBirthday() == null){
            errors.rejectValue("customerBirthday","birthday");
        }

        if(customer.getCustomerTypeId() == null){
            errors.rejectValue("customerTypeId","type");
        }

//        else
//        {
//            LocalDate startTime = product.getManufacturingDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            LocalDate endTime = product.getOutOfDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            if (Period.between(startTime,endTime).getDays() < 0)
//            {
//                errors.rejectValue("outOfDate","DateComparison");
//            }
//        }
    }
}
