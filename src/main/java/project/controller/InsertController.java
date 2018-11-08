package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Restaurant;
import project.service.RestaurantInsertService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InsertController {

    private final String path = "/insert";
    private RestaurantInsertService restaurantInsertService;
    private final List<String> tags = new ArrayList<>();

    @Autowired
    public InsertController(RestaurantInsertService restaurantInsertService) {
        this.restaurantInsertService = restaurantInsertService;
        // Add all available tags
        tags.add("Ítalskur");
        tags.add("Skyndibiti");
        tags.add("Pizza");
        tags.add("Tælenskur");
        tags.add("Kebab");
        tags.add("Vegan");
        tags.add("Tapas");
    }

    /**
     * Inserts a restaurant objet into the database
     * @param restaurant to insert into the database
     * @param model for the jsp file returned
     * @return the name of the jsp file to use
     */
    @RequestMapping(value = path, method = RequestMethod.POST)
    public String InsertRestaurant(@ModelAttribute("restaurant") Restaurant restaurant, Model model) {
        // Saves the restaurant to the database
        restaurantInsertService.save(restaurant);

        // Gets things ready for a new restaurant to be added
        model.addAttribute("tags", tags);
        model.addAttribute("restaurant", new Restaurant());

        // Information for the inserted restaurant to inform the user the inserted restaurant
        model.addAttribute("newRestaurant", restaurant);
        model.addAttribute("inserted", true);
        return path + "/InsertRestaurant";
    }

    /**
     * Displays a form to insert values for new restaurant
     * @param model for information for the jsp file
     * @return the name of the jsp file to use
     */
    @RequestMapping(value = path, method = RequestMethod.GET)
    public String insertHome( Model model) {
        model.addAttribute("tags", tags);
        model.addAttribute("restaurant", new Restaurant());
        return path + "/InsertRestaurant";
    }
}
