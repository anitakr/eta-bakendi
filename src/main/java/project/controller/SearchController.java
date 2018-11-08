package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Restaurant;
import project.service.RestaurantSearchService;

import java.util.List;

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
    private RestaurantSearchService restaurantSearchService;

    @Autowired
    public SearchController(RestaurantSearchService restaurantSearchService) {
        this.restaurantSearchService = restaurantSearchService;
    }



    /** search()
     * Path: "/search"
     * Purpose: Displays the search home with input fields for the search
     *
     * @return the input fields for the search
     */
    @RequestMapping(value = path, method = RequestMethod.GET)
    public String searchHome(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return path + "/Search";
    }

    @RequestMapping(value = path, method = RequestMethod.POST)
    public String search(@ModelAttribute("restaurant") Restaurant restaurant, Model model) {
        List<Restaurant> restaurantList = restaurantSearchService.search(restaurant);
                model.addAttribute("results", restaurantList);
        return path + "/Search";
    }

}
