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
import project.service.RestaurantLookUpService;
import java.util.List;


@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    private final String path = "/restaurant";
    private RestaurantLookUpService restaurantLookUpService;

    @Autowired
    public RestaurantController(RestaurantLookUpService restaurantLookUpService) {
        this.restaurantLookUpService = restaurantLookUpService;
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
     * Adds a new reviw to a restaurant with the given id
     * @param review to be added
     * @param id of the restaurant that gets the new revies
     * @param model for the jsp file returned
     * @return the name of the jsp file to show to the user
     */
    @RequestMapping(value="/{id}",  method = RequestMethod.POST)
    public String review(@ModelAttribute("review")Review review, @PathVariable long id, Model model) {

        // Get the restaurant the review is for
        Restaurant restaurant = restaurantLookUpService.findOne(id);

        // Add the new review with the correct username
        List<Review> reviews = restaurant.getReviewList();
        reviews.add(review);
        review.setRestaurant(restaurant);
        //TODO connect to autservice
        review.setUsername("username");
        restaurant.setReviewList(reviews);
        // Save the restaurant with the added review to the database
        restaurantLookUpService.save(restaurant);

        // Add the new restaurant to model so user can se the newly added review
        model.addAttribute("restaurant", restaurant);
        return path + "/Restaurant";
    }
}
