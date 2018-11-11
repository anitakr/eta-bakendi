package project.service;

import project.persistence.entities.User;

import java.util.List;

/** UserService
 * Purpose: Interface for a service that uses the user repository.
 *
 * @author Elvar (eas20@hi.is)
 */
public interface UserService {

    // Save a user in the database
    User save(User user);

    // Delete a user from the database
    void delete(User user);

    // Find all users from the database
    List<User> findAll();

    // Find a user by its username and password
    User findByNameAndPass(String username, String password);

    // Find a user by the username
    User findByName(String username);

    // Find a user by it's email
    User findByEmail(String email);

}
