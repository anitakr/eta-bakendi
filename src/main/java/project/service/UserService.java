package project.service;

import project.persistence.entities.User;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete(User user);

    List<User> findAll();

    User findByNameAndPass(String username, String password);

    User findByName(String username);

    User findByEmail(String password);

}
