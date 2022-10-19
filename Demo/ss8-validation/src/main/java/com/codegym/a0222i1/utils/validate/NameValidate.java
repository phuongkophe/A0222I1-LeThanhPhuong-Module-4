package com.codegym.a0222i1.utils.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = NameValidator.class)
public @interface NameValidate {
    String message() default "Tên không đúng định dạng";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
