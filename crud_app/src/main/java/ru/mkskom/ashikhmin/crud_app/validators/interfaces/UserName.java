package ru.mkskom.ashikhmin.crud_app.validators.interfaces;


import ru.mkskom.ashikhmin.crud_app.validators.NameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
public @interface UserName {

    String message() default "{IpAddress.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
