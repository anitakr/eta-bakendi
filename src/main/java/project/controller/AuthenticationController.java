package project.controller;

import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import project.persistence.entities.User;
import project.service.AuthorizationService;
import project.service.UserService;

import javax.xml.ws.Response;


/** AuthenticationController
 * Path: "/"
 * Purpose: Controller for the authentication part of Éta.
 *
 * @author Elvar (eas20@hi.is)
 */
@RestController
public class AuthenticationController {

    // ===================
    // Instance Variables
    // ===================
    private final UserService userService;
    private final UserValidator userValidator;
    private final AuthorizationService authorizationService;

    // =====================
    // Dependency Injection
    // =====================

    /** AuthenticationController(...)
     * Purpose: Constructor for the controller.
     * The parameters are all dependencies.
     *
     * @param userService Service with access to the database.
     * @param userValidator Validator for the sign up form.
     * @param authorizationService Service to handle the session.
     */
    @Autowired
    public AuthenticationController(UserService userService,
                                    UserValidator userValidator,
                                    AuthorizationService authorizationService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.authorizationService = authorizationService;
    }

    /** initBinder(WebDataBinder binder)
     * Purpose: Binds the validator to the page.
     *
     * @param binder Binder to bind the validator to he page
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }


    // =============
    // Page Methods
    // =============


    /** signup(User user, BindingResult res)
     * Path: "/signup"
     * Purpose: Display the signup page with POST.
     * After the user has filled out the sign up form.
     *
     * @param user The user created from the form
     * @param res Objects that holds info about error created during the validation process
     * @return The view
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User signupPost(@RequestBody @Validated User user, BindingResult res){
        System.out.println("ADFADf");
        // If the validator found any error we show the form again with error messages
        if(res.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // If the user did not select that he is a restaurant owner he is set as CASUAL user
        if(user.getType() == null) {
            user.setType(User.Type.CASUAL);
        }

        this.userService.save(user);
        return user;
    }


    /** login(User user)
     * Path: "/login"
     * Purpose: Display the signup page with POST.
     * After user has filled out the form.
     *
     * @param user The form from the user.
     * @return The view
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User loginPost(@RequestBody User user){

        User u = this.userService.findByNameAndPass(user.getUsername(), user.getPassword()); // Search for user

        this.authorizationService.setUser(u); // Update the session

        // Check if the login successful, then redirect to the home page
        if(this.authorizationService.isLoggedIn()) {
            return this.authorizationService.getUser();
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
