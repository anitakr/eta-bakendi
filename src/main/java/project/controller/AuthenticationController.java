package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** AuthenticationController
 * Path: "/authentication"
 * Purpose: Controller for the authentication part of Éta.
 *
 */
@Controller
public class AuthenticationController {

    // ===================
    // Instance Variables
    // ===================
    private final String path = "/authentication";

    // =====================
    // Dependency Injection
    // =====================
    @Autowired
    public AuthenticationController(/* Dependencies go here */) {
        // Instance Variables definition
        // etc.
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
    public String signup(){
        return path + "/SignUp";
    }

    /** login()
     * Path: "/authentication/login"
     * Purpose:
     *
     * @return
     */
    @RequestMapping(value = path + "/login", method = RequestMethod.GET)
    public String login(){
        return path + "/Login";
    }
}
