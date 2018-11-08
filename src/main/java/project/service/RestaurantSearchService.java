package project.service;

import project.persistence.entities.Restaurant;

import java.util.List;

public interface RestaurantSearchService {

    /**
     * Searches for restaurant matching the properties of the given restaurant
     * @param restaurant that contains the search properties
     * @return a list of Restaurant object that match the search criteria
     */
        List<Restaurant> search(Restaurant restaurant);
    }

