package com.codegym.a0222i1.utils.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameValidate, String> {
    @Override
    public void initialize(NameValidate constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^[A-Za-z ]{4,}$");
    }
}
