package project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Restaurant;
import project.persistence.repositories.RestaurantRepository;
import project.service.RestaurantLookUpService;

@Service
public class RestaurantLookUpServiceImplementation implements RestaurantLookUpService {

    RestaurantRepository repository;

    @Autowired
    public RestaurantLookUpServiceImplementation(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant findOne(Long id) {
        return repository.findOne(id);
    }
}
