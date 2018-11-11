package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.User;
import project.persistence.repositories.UserRepository;
import project.service.UserService;

import java.util.List;

/** UserServiceImplementation
 * Purpose: Implementation of the interface for a service for the user repository.
 * Used by the AuthernticationController in its Login/SignUp/Logout process.
 *
 * @author Elvar (eas20@hi.is)
 */
@Service
public class UserServiceImplementation implements UserService {

    // ===================
    // Instance Variables
    // ===================
    private UserRepository userRepo;


    // =====================
    // Dependency Injection
    // =====================

    /** UserServiceImplementation(...)
     * Purpose: Constructor for the service.
     *
     * @param userRepo The user repository to access the database.
     */
    @Autowired
    public UserServiceImplementation(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    // ==================
    // Interface Methods
    // ==================

    // Save a user in the database
    @Override
    public User save(User user) {
        return this.userRepo.save(user);
    }

    // Delete a user from the database
    @Override
    public void delete(User user) {
        this.userRepo.delete(user);
    }

    // Find all users from the database
    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    // Find a user nyt the username and password
    @Override
    public User findByNameAndPass(String username, String password) {
        return this.userRepo.findByNameAndPass(username, password);
    }

    // Find a user by the username
    @Override
    public User findByName(String username) {
        return this.userRepo.findByName(username);
    }

    // Find a user by it's email
    @Override
    public User findByEmail(String email) {
        return this.userRepo.findByEmail(email);
    }

}
