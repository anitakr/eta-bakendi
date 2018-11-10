package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Restaurant;
import project.service.AuthorizationService;
import project.service.RestaurantInsertService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InsertController {

    private final String path = "/insert";
    private RestaurantInsertService restaurantInsertService;
    private AuthorizationService authorizationService;
    private final List<String> genres = new ArrayList<>();

    @Autowired
    public InsertController(RestaurantInsertService restaurantInsertService, AuthorizationService authorizationService) {
        this.restaurantInsertService = restaurantInsertService;
        this.authorizationService = authorizationService;
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
    public String InsertRestaurant(@ModelAttribute("restaurant") Restaurant restaurant, Model model) {

        // TODO is user logged in?
        // Saves the restaurant to the database
        restaurantInsertService.save(restaurant);

        // Gets things ready for a new restaurant to be added
        model.addAttribute("genres", genres);
        model.addAttribute("restaurant", new Restaurant());

        // Information for the inserted restaurant to inform the user the inserted restaurant
        model.addAttribute("newRestaurant", restaurant);
        model.addAttribute("inserted", true);
        return path + "/InsertRestaurant";
    }

    /**
     * Displays a form to insert values for new restaurant
     *
     * @param model for information for the jsp file
     * @return the name of the jsp file to use
     */
    @RequestMapping(value = path, method = RequestMethod.GET)
    public String insertHome(Model model) {
        // TODO is user logged in?  if note redirect to login
        model.addAttribute("genres", genres);
        model.addAttribute("restaurant", new Restaurant());
        return path + "/InsertRestaurant";
    }
}
