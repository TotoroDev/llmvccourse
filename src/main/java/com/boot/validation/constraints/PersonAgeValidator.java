package com.boot.validation.constraints;

import com.boot.validation.annotations.Age;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

public class PersonAgeValidator implements ConstraintValidator<Age, Date> {

    private int acceptableAge;

    @Override
    public void initialize(Age constraintAnnotation) {
        this.acceptableAge = constraintAnnotation.age();
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        return getUserAge(Optional.ofNullable(date)) > acceptableAge;
    }

    private int getUserAge(final Optional<Date> dateOfBirth) {
        return dateOfBirth.map(Date::toInstant)
                .map(instant -> instant.atZone(ZoneId.systemDefault()))
                .map(ZonedDateTime::toLocalDate)
                .map(date -> Period.between(date, LocalDate.now(ZoneId.systemDefault())).getYears())
                .orElse(-1);
    }
}
