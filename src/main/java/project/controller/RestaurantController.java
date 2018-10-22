package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Restaurant;
import project.service.RestaurantLookUpService;

import java.util.ArrayList;
import java.util.List;



@Controller
public class RestaurantController {

    private final String path = "/restaurant";
    private RestaurantLookUpService restaurantLookUpService;

    @Autowired
    public RestaurantController(RestaurantLookUpService restaurantLookUpService) {
        this.restaurantLookUpService = restaurantLookUpService;
    }



    @RequestMapping(value = path + "/{id}", method = RequestMethod.GET)
    public String restaurant(@PathVariable long id, Model model) {
        Restaurant resault = restaurantLookUpService.findOne(id);
        Restaurant restaurant = new Restaurant();
        restaurant.setId(id);
        restaurant.setName("Vegamót");
        restaurant.setLocation("Hér og þar");
        model.addAttribute("restaurant", restaurant);
        return path + "/Restaurant";
    }
}
