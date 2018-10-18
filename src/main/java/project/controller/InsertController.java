package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InsertController {

    private final String path = "/insert";

    @Autowired
    public InsertController(/* */) {}

    @RequestMapping(value = path + "/InsertRestaurant", method = RequestMethod.GET)

    public String InsertRestaurant() {
        return path + "/InsertRestaurant";
    }

    //Bæta við veitingastað
    //public String insertRestaurant(....)
}
