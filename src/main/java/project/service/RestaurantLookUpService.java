package project.service;

import project.persistence.entities.Restaurant;

public interface RestaurantLookUpService {

    Restaurant findOne(Long id);
}
