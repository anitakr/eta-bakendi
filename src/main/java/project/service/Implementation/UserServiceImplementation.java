package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.User;
import project.persistence.repositories.UserRepository;
import project.service.UserService;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {


    private UserRepository userRepo;

    // Dependency Injection
    @Autowired
    public UserServiceImplementation(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User save(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public void delete(User user) {
        this.userRepo.delete(user);
    }

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public User findByNameAndPass(String username, String password) {
        return this.userRepo.findByNameAndPass(username, password);
    }

    @Override
    public User findByName(String username) {
        return this.userRepo.findByName(username);
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepo.findByEmail(email);
    }

}
