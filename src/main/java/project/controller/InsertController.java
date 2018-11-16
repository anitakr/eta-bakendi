package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import project.persistence.entities.Restaurant;
import project.persistence.entities.User;
import project.service.AuthorizationService;
import project.service.RestaurantInsertService;

import java.util.ArrayList;
import java.util.List;

/**
 * This controller handles it when a user inserts a restaurant to the database
 */
@Controller
public class InsertController {

    private final String path = "/insert";
    private RestaurantInsertService restaurantInsertService;
    private AuthorizationService authorizationService;
    private final List<String> genres = new ArrayList<>();
    private List<String> prices = new ArrayList<>();


    @Autowired
    public InsertController(RestaurantInsertService restaurantInsertService, AuthorizationService authorizationService) {
        this.restaurantInsertService = restaurantInsertService;
        this.authorizationService = authorizationService;
        prices.add("Ódýrt");
        prices.add("Milli");
        prices.add("Dýrt");
        // Add all available genres
        genres.add("Ítalskur");
        genres.add("Skyndibiti");
        genres.add("Pizza");
        genres.add("Tælenskur");
        genres.add("Kebab");
        genres.add("Vegan");
        genres.add("Tapas");
    }

    /**
     * Inserts a restaurant objet into the database
     *
     * @param restaurant to insert into the database
     * @param model      for the jsp file returned
     * @return the name of the jsp file to use
     */
    @RequestMapping(value = path, method = RequestMethod.POST)
    public ModelAndView InsertRestaurant(@ModelAttribute("restaurant") Restaurant restaurant, Model model) {
        System.out.println(authorizationService.getUser().getType());
        // User can only insert a restaurant if he is logged in and is a manager
        if (authorizationService.isLoggedIn() && authorizationService.getUser().getType() == User.Type.MANAGER) {

            // Saves the restaurant to the database
            restaurantInsertService.save(restaurant);

            // Gets things ready for a new restaurant to be added
            model.addAttribute("genres", genres);
            model.addAttribute("prices", prices);
            model.addAttribute("restaurant", new Restaurant());

            // Information for the inserted restaurant to inform the user the inserted restaurant
            model.addAttribute("newRestaurant", restaurant);
            model.addAttribute("inserted", true);
            return new ModelAndView( "insert/InsertRestaurant");

            // If user is not logged in we redirect him to the log in site
        } else {
            return new ModelAndView(new RedirectView("/login"));
        }
    }

    /**
     * Displays a form to insert values for new restaurant
     *
     * @param model for information for the jsp file
     * @return the name of the jsp file to use
     */
    @RequestMapping(value = path, method = RequestMethod.GET)
    public ModelAndView insertHome(Model model) {

        // User can only visit the insert part of the page if he is logged in and is a manager
        if (authorizationService.isLoggedIn() && authorizationService.getUser().getType() == User.Type.MANAGER) {
            // Add all genres and price options
            model.addAttribute("genres", genres);
            model.addAttribute("prices", prices);

            // New empty restaurant
            model.addAttribute("restaurant", new Restaurant());
            return new ModelAndView("insert/InsertRestaurant");

            // If user is not logged in we redirect him to the log in site
        } else
            return new ModelAndView(new RedirectView("/login"));
    }
}
