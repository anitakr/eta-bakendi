package project.service;

import project.persistence.entities.Restaurant;
public interface RestaurantInsertService {

    /**
     * Saves a restaurant object to the database
     * @param restaurant to be saved
     * @return the restaurant that was just saved
     */
    Restaurant save(Restaurant restaurant);
}
