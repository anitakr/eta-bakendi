package project.persistence.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.User;


/** UserRepository
 * Purpose: Repository interface for the User entity.
 *
 * @author Elvar (eas20@hi.is)
 */
public interface UserRepository extends JpaRepository<User, Long>  {

    // Save a user in the database
    User save(User user);

    // Delete a user from the database
    void delete(User user);

    // Find all users from the database
    List<User> findAll();

    // Find a user by its username and password
    @Query(value = "SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
    User findByNameAndPass(String username, String password);

    // Find a user by the username
    @Query(value = "SELECT u FROM User u WHERE u.username = ?1")
    User findByName(String username);

    // Find a user by it's email
    @Query(value = "SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
}
