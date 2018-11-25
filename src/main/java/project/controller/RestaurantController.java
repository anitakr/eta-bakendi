package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Restaurant;
import project.persistence.entities.Review;
import project.service.AuthorizationService;
import project.service.RestaurantLookUpService;
import java.util.List;

/**
 * This controller displays one restaurant and handles reviews posted
 */
@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    private final String path = "/restaurant";
    private RestaurantLookUpService restaurantLookUpService;
    private AuthorizationService authorizationService;

    @Autowired
    public RestaurantController(RestaurantLookUpService restaurantLookUpService, AuthorizationService authorizationService) {
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
    public String restaurant(@PathVariable long id, Model model) {
        // Get the restaurant from the database
        Restaurant result = restaurantLookUpService.findOne(id);
        // Add it to the model
        model.addAttribute("restaurant", result);
        // Add a empty review if the user wants to add one
        model.addAttribute("review", new Review());
        return path + "/Restaurant";
    }

    /**
     * Adds a new review to a restaurant with the given id
     * @param review to be added
     * @param id of the restaurant that gets the new reviews
     * @param model for the jsp file returned
     * @return the name of the jsp file to show to the user
     */
    @RequestMapping(value="/{id}",  method = RequestMethod.POST)
    public String review(@ModelAttribute("review")Review review, @PathVariable long id, Model model) {
        // Get the restaurant the review is for
        Restaurant restaurant = restaurantLookUpService.findOne(id);

        // User can only post a review if he is logged in
        if (authorizationService.isLoggedIn()) {
            // Add the new review with the correct username to the restaurant and save it
            List<Review> reviews = restaurant.getReviewList();
            reviews.add(review);
            review.setRestaurant(restaurant);
            review.setUsername(authorizationService.getUser().getUsername());
            restaurant.setReviewList(reviews);
            restaurantLookUpService.save(restaurant);

            // If user is not logged in we do not save is his review but show an error message
        } else {
            model.addAttribute("noUserForReview", true);
        }

        // Add the new restaurant to model again to display it
        model.addAttribute("restaurant", restaurant);
        return path + "/Restaurant";
    }
}
