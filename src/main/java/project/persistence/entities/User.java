package project.persistence.entities;

import javax.persistence.*;

/** User
 * Purpose: Entity that stores users info.
 *
 * @author Elvar (eas20@hi.is)
 */
@Entity
@Table(name = "users") // If you want to specify a table name, you can do so here
public class User {

    /** Type()
     * Purpose: Enum to simplify the process when setting the type field of user.
     *
     */
    public enum Type {
        MANAGER, CASUAL
    }


    // =======
    // Fields
    // =======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    private Type type;


    // =============
    // Constructors
    // =============

    /** User()
     * Purpose: Empty constructor
     *
     */
    public User() {
    }

    /** User(...)
     * Purpose: Constructor to inject all the info as you create the object.
     *
     */
    public User(String username, String password, String email, Type type) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;
    }

    // ==============================
    // Getters, Setters and ToString
    // ==============================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                '}';
    }
}
