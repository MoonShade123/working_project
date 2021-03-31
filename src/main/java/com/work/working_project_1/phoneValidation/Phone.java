package com.work.working_project_1.phoneValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

    String message() default "Invalid characters in phone number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
