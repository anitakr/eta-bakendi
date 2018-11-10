package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.service.AuthorizationService;

/** HomeController
 * Path: "/"
 * Purpose: Controller for the home page of Éta.
 *
 * @author Elvar (eas20@hi.is)
 */
@Controller
public class HomeController {

    // ===================
    // Instance Variables
    // ===================
    private final String path = "";
    private final AuthorizationService authorizationService;


    // =====================
    // Dependency Injection
    // =====================

    /** HomeController(...)
     * Path: "/authentication/signup"
     * Purpose: Constructor for the controller with dependency injections
     *
     * @param authorizationService Service to handle the session.
     */
    @Autowired
    public HomeController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }


    // =============
    // Page Methods
    // =============

    /** home(Model model)
     * Path: "/"
     * Purpose: Display the home page.
     *
     * @return The view
     */
    @RequestMapping(value = path, method = RequestMethod.GET)
    public String home(Model model){

        // The model uses the user attribute in its menu.
        if(this.authorizationService.isLoggedIn()) {
            model.addAttribute("user", this.authorizationService.getUser());
        }

        return "Index";
    }

}
