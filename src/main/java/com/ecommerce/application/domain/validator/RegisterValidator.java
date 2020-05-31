package com.ecommerce.application.domain.validator;


import com.ecommerce.application.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegisterValidator implements Validator {

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User form = (User) o;
        validateUsername(errors, form);
    }

    private void validateUsername(Errors errors, User form) {
        if (userDetailsService.loadUserByUsername(form.getUsername()) != null) {
            errors.reject("username.exists", "User with this username already exists");
        }
    }
}
