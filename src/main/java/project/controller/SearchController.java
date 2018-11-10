package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.persistence.entities.Restaurant;
import project.service.RestaurantSearchService;

import java.util.ArrayList;
import java.util.List;

/**
 * SearchController
 * Path: "/search"
 * Purpose: Controller for the home page of Éta.
 */
@Controller
public class SearchController {

    private final String path = "/search";
    private RestaurantSearchService restaurantSearchService;
    private List<String> prices = new ArrayList<>();

    @Autowired
    public SearchController(RestaurantSearchService restaurantSearchService) {
        this.restaurantSearchService = restaurantSearchService;
        prices.add("Ódýrt");
        prices.add("Milli");
        prices.add("Dýrt");
    }


    /**
     * search()
     * Path: "/search"
     * Purpose: Displays the search home with input fields for the search
     *
     * @return the search jsp with input fields
     */
    @RequestMapping(value = path, method = RequestMethod.GET)
    public String searchHome(Model model) {
        // Search parameters will be collected into a Restaurant object
        model.addAttribute("restaurant", new Restaurant());
        // Show all prices category
        model.addAttribute("prices", prices);
        return path + "/Search";
    }

    /**
     * Handles when the user post a search request
     * @param restaurant containing search parameters
     * @param searchByName true if user is searching by name or searching by price and genres
     * @param model for the jsp
     * @return a jsp file containing the search site with added search resaults
     */
    @RequestMapping(value = path, method = RequestMethod.POST)
    public String search(@ModelAttribute("restaurant") Restaurant restaurant, @RequestParam("useName") boolean searchByName, Model model) {
        List<Restaurant> results;

        // Are we are searching by name or by price and genre
        if (searchByName) {
            results = restaurantSearchService.searchByName(restaurant);
        } else {
            results = restaurantSearchService.search(restaurant);
        }
        // Add results to model
        model.addAttribute("results", results);

        // Get things ready for new search
        model.addAttribute("prices", prices);
        model.addAttribute("restaurant", new Restaurant());
        return path + "/Search";
    }
}
