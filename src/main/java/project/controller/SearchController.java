package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Restaurant;
import project.service.AuthorizationService;
import project.service.RestaurantSearchService;

import java.util.ArrayList;
import java.util.List;

/**
 * SearchController
 * Path: "/search"
 * Purpose: Controller for the home page of Éta.
 */
@RestController
public class SearchController {

    private final String path = "/search";
    private RestaurantSearchService restaurantSearchService;
    private List<String> prices = new ArrayList<>();
    private final List<String> genres = new ArrayList<>();
    private final AuthorizationService authorizationService;

    @Autowired
    public SearchController(RestaurantSearchService restaurantSearchService, AuthorizationService authorizationService) {
        this.restaurantSearchService = restaurantSearchService;
        this.authorizationService = authorizationService;

    }

    /**
     * Handles when the user post a search request
     *
     * @param restaurant   containing search parameters
     * @param searchByName true if user is searching by name or searching by price and genres
     * @return a jsp file containing the search site with added search resaults
     */
//    @RequestMapping(value = path, method = RequestMethod.POST)
    @PostMapping("/search")
    public List<Restaurant> search(@RequestBody Restaurant restaurant, @RequestParam Boolean searchByName) {

        List<Restaurant> results;
        // Are we are searching by name or by price and genre
        if (searchByName) {
            results = restaurantSearchService.searchByName(restaurant);
        } else {
            results = restaurantSearchService.search(restaurant);
        }
        return results;
    }
}
