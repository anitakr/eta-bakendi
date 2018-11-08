package project.persistence.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.User;

public interface UserRepository extends JpaRepository<User, Long>  {
    User save(User user);

    void delete(User user);

    List<User> findAll();

    @Query(value = "SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
    User findByNameAndPass(String username, String password);

    @Query(value = "SELECT u FROM User u WHERE u.username = ?1")
    User findByName(String username);

    @Query(value = "SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
}
