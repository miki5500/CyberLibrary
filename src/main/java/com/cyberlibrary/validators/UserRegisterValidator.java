package com.cyberlibrary.validators;


import com.cyberlibrary.constants.SpringProjectConstants;
import com.cyberlibrary.entity.userEntity.User;
import com.cyberlibrary.helpers.SpringProjectUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.sql.SQLOutput;

public class UserRegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return User.class.equals(cls);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User u = (User) o;

        if (u.getEmail() != null) {
            boolean isMatch = SpringProjectUtils.checkEmailOrPassword(SpringProjectConstants.EMAIL_PATTERN, u.getEmail());
            if (!isMatch) {
                errors.rejectValue("email", "Adres email niepoprawny");
            }
        }

        if (u.getPassword() != null) {
            boolean isMatch = SpringProjectUtils.checkEmailOrPassword(SpringProjectConstants.PASSWORD_PATTERN, u.getPassword());
            if (!isMatch) {
                errors.rejectValue("password", "Hasło jest niepoprawne");
            }
        }
    }

    public void validateEmailExist(User user, Errors errors) {
        if (user != null) {
            errors.rejectValue("email", "Użytkownik o takim adresie już istnieje");
        }
    }

}
