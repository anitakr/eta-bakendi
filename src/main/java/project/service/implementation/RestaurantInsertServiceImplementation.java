package project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Restaurant;
import project.persistence.repositories.RestaurantRepository;
import project.service.RestaurantInsertService;

@Service
public class RestaurantInsertServiceImplementation implements RestaurantInsertService {

    RestaurantRepository repository;

    // Dependency Injection
    @Autowired
    public RestaurantInsertServiceImplementation(RestaurantRepository repository) {
        this.repository = repository;
    }


    @Override
    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }
}
