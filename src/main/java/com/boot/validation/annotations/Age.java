package com.boot.validation.annotations;

import com.boot.validation.constraints.PersonAgeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PersonAgeValidator.class)
public @interface Age {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "{user.not-valid.age}";
    int age() default 18;
}
