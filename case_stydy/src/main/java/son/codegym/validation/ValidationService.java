package son.codegym.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import son.codegym.entity.Service;

import java.io.Serializable;

public class ValidationService implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Service.class.isAssignableFrom(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        Service service = (Service) target;
        if (service.getRentTypeId() == null){
            errors.rejectValue("rentTypeId","type");
        }

        if (service.getServiceTypeId() == null){
            errors.rejectValue("serviceTypeId","type");
        }
    }
}
