package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** SearchController
 * Path: "/search"
 * Purpose: Controller for the home page of Éta.
 *
 */
@Controller
public class SearchController {

    // ===================
    // Instance Variables
    // ===================
    private final String path = "/search";


    // =====================
    // Dependency Injection
    // =====================
    @Autowired
    public SearchController(/* Dependencies go here */) {
        // Instance Variables definition
        // etc.
    }


    // =============
    // Page Methods
    // =============

    /** search()
     * Path: "/search"
     * Purpose:
     *
     * @return
     */
    @RequestMapping(value = path, method = RequestMethod.GET)
    public String search() {
        return path + "/Search";
    }

}
