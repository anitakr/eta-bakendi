package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Restaurant;
import project.service.AuthorizationService;

import java.util.ArrayList;
import java.util.List;

/**
 * HomeController
 * Path: "/"
 * Purpose: Controller for the home page of Éta.
 *
 * @author Elvar (eas20@hi.is)
 */
@RestController
public class HomeController {

    // ===================
    // Instance Variables
    // ===================
//    private final AuthorizationService authorizationService;


    // =====================
    // Dependency Injection
    // =====================

    /**
     * HomeController(...)
     * Purpose: Constructor for the controller with dependency injections
     *
     * @param authorizationService Service to handle the session.
     */
//    @Autowired
//    public HomeController(AuthorizationService authorizationService) {
//        this.authorizationService = authorizationService;
//    }


    // =============
    // Page Methods
    // =============

    /**
     * home(Model model)
     * Path: "/"
     * Purpose: Display the home page.
     *
     * @return The view
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {

        // For the menu bar
//        if (this.authorizationService.isLoggedIn()) {
//            model.addAttribute("usersession", this.authorizationService.getUser());
//        }

        return "Index";
    }

    /**
     * search()
     * Path: "/search"
     * Purpose: Displays the search home with input fields for the search
     *
     * @return the search jsp with input fields
     */
    //@RequestMapping(value = path, method = RequestMethod.GET)
//    @GetMapping("/search")
//    public Restaurant searchHome(Model model) {
//
////        if(this.authorizationService.isLoggedIn()) {
////            model.addAttribute("usersession", this.authorizationService.getUser());
////        }
//
//        // Search parameters will be collected into a Restaurant object
////        model.addAttribute("restaurant", new Restaurant());
////        // Show all prices category
////        model.addAttribute("prices", prices);
////        model.addAttribute("genres", genres);
//        return new Restaurant();
//    }
//
//    /**
//     * Handles when the user post a search request
//     *
//     * @param restaurant   containing search parameters
//     * @param searchByName true if user is searching by name or searching by price and genres
//     * @return a jsp file containing the search site with added search resaults
//     */
////    @RequestMapping(value = path, method = RequestMethod.POST)
//    @PostMapping("/search")
//    public List<Restaurant> search(@RequestBody Restaurant restaurant) {
//        List<Restaurant> results;
//        List<Restaurant> restaurants = new ArrayList<>();
//        Restaurant restaurant1 = new Restaurant();
//        restaurant1.setName("NAME");
//        //return path + "/Search";
//        restaurants.add(restaurant1);
//        return restaurants;
//    }
}
