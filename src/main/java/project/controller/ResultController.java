package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Restaurant;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ResultController {

    @Autowired
    public ResultController() {}

    @RequestMapping(value="/results", method = RequestMethod.GET)
    public String results(Model model) {
        // TODO connect to repository
        List<Restaurant> results = new ArrayList<>();
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setName("Veitingastaður 1");
        restaurant1.setId(0);
        restaurant1.setLocation("Location 1");
        Restaurant restaurant2 = new Restaurant();
        restaurant2.setName("Veitingastaður 2");
        restaurant2.setLocation("Location 2");
        restaurant2.setId(1);
        Restaurant restaurant3 = new Restaurant();
        restaurant3.setName("Veitingastaður 3");
        restaurant3.setId(2);
        restaurant3.setLocation("Location 3");
        results.add(restaurant1);
        results.add(restaurant2);
        results.add(restaurant3);

        model.addAttribute("results", results);
        return "Results";
    }

    @RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET)
    public String restaurant(@PathVariable long id, Model model) {
        // TODO connect to repository
        Restaurant restaurant = new Restaurant();
        restaurant.setId(id);
        restaurant.setName("Vegamót");
        restaurant.setLocation("Hér og þar");
        model.addAttribute("restaurant", restaurant);
        return "Restaurant";
    }
}
