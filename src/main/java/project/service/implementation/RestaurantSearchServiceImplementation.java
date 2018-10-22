package project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Restaurant;
import project.persistence.repositories.RestaurantRepository;
import project.service.RestaurantSearchService;

import java.util.List;

@Service
public class RestaurantSearchServiceImplementation implements RestaurantSearchService {

    RestaurantRepository repository;

    @Autowired
    public RestaurantSearchServiceImplementation(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Restaurant> search() {
        return repository.findByQuery();
    }
}
