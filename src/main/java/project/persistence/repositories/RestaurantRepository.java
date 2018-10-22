package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    /**
     * Save restaurant to the database
     * @param restaurant to be saved
     * @return the restaurant that was saved
     */
    Restaurant save(Restaurant restaurant);

    /**
     * Delete a restaurant from the datbase
     * @param restaurant to be deleted
     */
    void delete(Restaurant restaurant);

    /**
     * Find one restaurant in the database after id
     * @param id of the restaurant to be found
     * @return the restaurant with the given id
     */
    @Query(value = "SELECT r FROM Restaurant r WHERE r.id = ?1")
    Restaurant findOne(Long id);

    /**
     * Search for a restaurant with the inserted search parameters
     * @return a list of restaurants that match the query
     */
    // TODO fix this
    @Query(value = "SELECT p FROM Restaurant p where length(p.name) >= 3 ")
    List<Restaurant> findByQuery();
}

