package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** HomeController
 * Path: "/"
 * Purpose: Controller for the home page of Éta.
 *
 */
@Controller
public class HomeController {

    // ===================
    // Instance Variables
    // ===================
    private final String path = "";


    // =====================
    // Dependency Injection
    // =====================
    @Autowired
    public HomeController(/* Dependencies go here */) {
        // Instance Variables definition
        // etc.
    }


    // =============
    // Page Methods
    // =============

    /** home()
     * Path: "/"
     * Purpose:
     *
     * @return
     */
    @RequestMapping(value = path, method = RequestMethod.GET)
    public String home(){
        /* To-do: Find if user is sign in and if send him to the authentication page */


        return path + "/Index";
    }

}
