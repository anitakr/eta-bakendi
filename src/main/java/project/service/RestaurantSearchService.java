package project.service;

import project.persistence.entities.Restaurant;

import java.util.List;

public interface RestaurantSearchService {

    /**
     * Searches for restaurant matching the properties of the given restaurant
     *
     * @param restaurant that contains the search properties
     * @return a list of Restaurant object that match the search criteria
     */
    List<Restaurant> search(Restaurant restaurant);

    /**
     * Searches for restaurants by name
     * @param restaurant to search for
     * @return a list of restaurant objects that have a name that match the name param
     */
    List<Restaurant> searchByName(Restaurant restaurant);
}

