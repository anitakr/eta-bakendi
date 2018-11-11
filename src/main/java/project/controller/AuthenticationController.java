package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.User;
import project.service.AuthorizationService;
import project.service.UserService;


/** AuthenticationController
 * Path: "/"
 * Purpose: Controller for the authentication part of Éta.
 *
 * @author Elvar (eas20@hi.is)
 */
@Controller
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

    /** signup(Model model)
     * Path: "/signup"
     * Purpose: Display the signup page with GET.
     *
     * @return The view
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model){

        model.addAttribute("user", new User()); // For the form

        model.addAttribute("currentUser", authorizationService.getUser());
        return "authentication/SignUp";
    }

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
    public String signupPost(@ModelAttribute("user") @Validated User user, BindingResult res){

        // If the validator found any error we show the form again with error messages
        if(res.hasErrors()) {
            return "authentication/SignUp";
        }

        // If the user did not select that he is a restaurant owner he is set as CASUAL user
        if(user.getType() == null) {
            user.setType(User.Type.CASUAL);
        }

        this.userService.save(user);
        return "redirect:/"; // Redirect the user to the home page.
    }

    /** login(Model model)
     * Path: "/login"
     * Purpose: Display the signup page with GET.
     *
     * @return The view
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){

        model.addAttribute("user", new User()); // For the form
        return "authentication/Login";
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
    public String loginPost(@ModelAttribute("user") User user){

        User u = this.userService.findByNameAndPass(user.getUsername(), user.getPassword()); // Search for user

        this.authorizationService.setUser(u); // Update the session

        // Check if the login successful, then redirect to the home page
        if(this.authorizationService.isLoggedIn()) {
            return "redirect:/";
        }
        else {
            return "authentication/Login";
        }
    }

    /** logout()
     * Path: "/logout"
     * Purpose: Log out the user.
     *
     * @return The view
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        this.authorizationService.setUser(null);
        return "redirect:/";
    }
}
