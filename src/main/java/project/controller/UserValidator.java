package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import project.persistence.entities.User;
import project.service.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;

    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }


    @Override
    public void validate(Object obj, Errors err) {

        User user = (User) obj;

        String username = user.getUsername();
        if(username.length() < 3 || username.length() > 16) {
            err.rejectValue("username", "user.username.length");
        }
        else if(this.userService.findByName(username) != null) {
            err.rejectValue("username", "user.username.exists");
        }

        String password = user.getPassword();
        if(password.length() < 4 || password.length() > 32) {
            err.rejectValue("password", "user.password.length");
        }

        String email = user.getEmail();
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);

        if(!m.find() || email.length() > 254) {
            err.rejectValue("email", "user.email.invalid");
        }
        else if(this.userService.findByEmail(email) != null) {
            err.rejectValue("email", "user.email.exists");
        }
    }

}
