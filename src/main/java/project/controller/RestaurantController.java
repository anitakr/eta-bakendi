package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import project.persistence.entities.Restaurant;
import project.persistence.entities.Review;
import project.persistence.entities.User;
import project.service.AuthorizationService;
import project.service.RestaurantLookUpService;
import project.service.UserService;

import java.util.List;

/**
 * This controller displays one restaurant and handles reviews posted
 */
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final String path = "/restaurant";
    private RestaurantLookUpService restaurantLookUpService;
    private UserService authorizationService;

    @Autowired
    public RestaurantController(RestaurantLookUpService restaurantLookUpService, UserService authorizationService) {
        this.restaurantLookUpService = restaurantLookUpService;
        this.authorizationService  = authorizationService;
    }

    /**
     * Shows a jps page for a restaurant with the given id. Also displays a form
     * to add a review to the restaurant.
     * @param id of the restaurant to be shown
     * @param model for the jsp file returned
     * @return name of the jsp file to use
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Restaurant restaurant(@PathVariable long id, Model model) {

        // Get the restaurant from the database
        Restaurant result = restaurantLookUpService.findOne(id);
        return result;
    }

    /**
     * Adds a new review to a restaurant with the given id
     * @param review to be added
     * @param id of the restaurant that gets the new reviews
     * @return the name of the jsp file to show to the user
     */
    @RequestMapping(value="/{id}",  method = RequestMethod.POST)
    public Restaurant review(@RequestBody Review review, @PathVariable long id) {

        // Get the restaurant the review is for
        Restaurant restaurant = restaurantLookUpService.findOne(id);


        // User can only post a review if he is logged in

        // For the menu bar

        // Add the new review with the correct username to the restaurant and save it
        List<Review> reviews = restaurant.getReviewList();
        reviews.add(review);
        review.setRestaurant(restaurant);
        review.setUsername(review.getUsername());
        restaurant.setReviewList(reviews);
        restaurantLookUpService.save(restaurant);

            // If user is not logged in we do not save is his review but show an error message
        return restaurant;
    }
}
