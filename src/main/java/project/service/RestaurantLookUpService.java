package project.service;

import project.persistence.entities.Restaurant;

public interface RestaurantLookUpService {

    /**
     * Finds a restaurant objects that has the id given
     * @param id of the restaurant that is being fetched from the database
     * @return a restaurant with the given id
     */
    Restaurant findOne(Long id);

    /**
     * Saves the restaurant object to the datatbase, used when reviews are added to a restaurant
     * @param restaurant to be saved with added reviews
     */
    void save(Restaurant restaurant);
}
