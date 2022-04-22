package ru.mkskom.ashikhmin.crud_app.validators;

import org.apache.catalina.User;
import ru.mkskom.ashikhmin.crud_app.regexes.Regexes;
import ru.mkskom.ashikhmin.crud_app.validators.interfaces.UserName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<UserName, String> {

    @Override
    public void initialize(UserName constraintAnnotation){}


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern =
                Pattern.compile(Regexes.ONLY_LETTERS);
        Matcher matcher = pattern.matcher(value);

        try{
            return matcher.matches();
        } catch (Exception e) {
            return false;
        }
    }
}
