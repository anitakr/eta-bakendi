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
 * Path: "/authentication"
 * Purpose: Controller for the authentication part of Éta.
 *
 * @author Elvar (eas20@hi.is)
 */
@Controller
public class AuthenticationController {

    // ===================
    // Instance Variables
    // ===================
    private final String path = "/authentication";
    private final UserService userService;
    private final UserValidator userValidator;
    private final AuthorizationService authorizationService;

    // =====================
    // Dependency Injection
    // =====================
    @Autowired
    public AuthenticationController(UserService userService,
                                    UserValidator userValidator,
                                    AuthorizationService authorizationService) {
        // Instance Variables definition
        // etc.
        this.userService = userService;
        this.userValidator = userValidator;
        this.authorizationService = authorizationService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }


    // =============
    // Page Methods
    // =============

    /** signup()
     * Path: "/authentication/signup"
     * Purpose:
     *
     * @return
     */
    @RequestMapping(value = path + "/signup", method = RequestMethod.GET)
    public String signup(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("users", this.userService.findAll());

        model.addAttribute("currentUser", authorizationService.getUser() );
        return path + "/SignUp";
    }

    /** signup()
     * Path: "/authentication/signup"
     * Purpose:
     *
     * @return
     */
    @RequestMapping(value = path + "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") @Validated User user, BindingResult res, Model model){
        System.err.println(res);
        if(res.hasErrors()) {
            return path + "/SignUp";
        }
        if(user.getType() == null) {
            user.setType(User.Type.CASUAL);
        }
        this.userService.save(user);
        model.addAttribute("users", this.userService.findAll());
        return path + "/SignUp";
    }

    /** login()
     * Path: "/authentication/login"
     * Purpose:
     *
     * @return
     */
    @RequestMapping(value = path + "/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("user", new User());
        return path + "/Login";
    }

    /** login()
     * Path: "/authentication/login"
     * Purpose:
     *
     * @return
     */
    @RequestMapping(value = path + "/login", method = RequestMethod.POST)
    public String loginPost(@ModelAttribute("user") User user, Model model){
        User u = this.userService.findByNameAndPass(user.getUsername(), user.getPassword());
        model.addAttribute("user", u);

        this.authorizationService.setUser(u);

        return path + "/Login";
    }
}
