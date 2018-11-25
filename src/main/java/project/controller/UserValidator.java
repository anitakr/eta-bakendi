package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import project.persistence.entities.User;
import project.service.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** UserValidator
 * Purpose: Validator to validate the user
 *
 * @author Elvar (eas20@hi.is)
 */
@Component
public class UserValidator implements Validator {

    // ===================
    // Instance Variables
    // ===================
    private final UserService userService;

    // ===================
    // Dependency Injection
    // ===================

    /** UserValidator(...)
     * Purpose: Constructor for the validator.
     *
     * @param userService Service with access to the database.
     */
    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;

    }

    // ===================
    // Interface Methods
    // ===================

    /** supports(Class<?> clazz)
     * Purpose: To check if a class is able to be validated by this validator
     *
     * @param clazz The class that is being checked
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }


    /** validate(Object obj, Errors err)
     * Purpose: Validate a object according to set rules.
     *
     * @param obj The object
     * @param err Dump site for the errors
     */
    @Override
    public void validate(Object obj, Errors err) {

        User user = (User) obj; // The user

        /* Username rules */

        // Length between 3 and 16
        String username = user.getUsername();

        if(username.length() < 3 || username.length() > 16) {
            err.rejectValue("username", "user.username.length");
        }
        // User with same name does not exist in the database
        else if(this.userService.findByName(username) != null) {
            err.rejectValue("username", "user.username.exists");
        }

        /* Password rules */
        String password = user.getPassword();

        // Length between 3 and 16
        if(password.length() < 4 || password.length() > 32) {
            err.rejectValue("password", "user.password.length");
        }


        /* Email rules */
        String email = user.getEmail();
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);

        // I valid email
        if(!m.find() || email.length() > 254) {
            err.rejectValue("email", "user.email.invalid");
        }
        // User with same email does not exist in the database
        else if(this.userService.findByEmail(email) != null) {
            err.rejectValue("email", "user.email.exists");
        }
    }

}
