package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import project.persistence.entities.InsertInformation;
import project.persistence.entities.Restaurant;
import project.persistence.entities.User;
import project.service.AuthorizationService;
import project.service.RestaurantInsertService;
import project.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * This controller handles it when a user inserts a restaurant to the database
 */
@RestController
public class InsertController {

    private final String path = "/insert";
    private RestaurantInsertService restaurantInsertService;
    private UserService authorizationService;
    private final List<String> genres = new ArrayList<>();
    private List<String> prices = new ArrayList<>();


    @Autowired
    public InsertController(RestaurantInsertService restaurantInsertService, UserService authorizationService) {
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
     * @return the name of the jsp file to use
     */
    @RequestMapping(value = path, method = RequestMethod.POST)
    public Restaurant InsertRestaurant(@RequestBody InsertInformation information) {

        // User can only insert a restaurant if he is logged in and is a manager
        if (authorizationService.findByNameAndPass(information.getUser().getUsername(), information.getUser().getPassword()) != null && information.getUser().getType() == User.Type.MANAGER) {

            // Saves the restaurant to the database
            restaurantInsertService.save(information.getRestaurant());

            return information.getRestaurant();

            // If user is not logged in we redirect him to the log in site
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not a valid user");
        }
    }

}
