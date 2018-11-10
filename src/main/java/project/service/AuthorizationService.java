package project.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import project.persistence.entities.User;

/** AuthorizationService
 * Purpose: Session handler for the current user.
 *
 * @author Elvar (eas20@hi.is)
 */
@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AuthorizationService {

    // ===================
    // Instance Variables
    // ===================
    private User user;


    // ===============
    // Public Methods
    // ===============

    /** isLoggedIn()
     * Purpose:
     *
     * @return Whether or not a user is currently logged in this session
     */
    public Boolean isLoggedIn() {
        return user != null;
    }

    /** getUser()
     * Purpose: Getter for the current user on this session.
     *
     * @return The current user
     */
    public User getUser(){
        return user;
    }

    /** setUser(User user)
     * Purpose: Setter for the current user on this session.
     * To log out you have to pass a null in to this method.
     *
     * @param user The new user in this session.
     */
    public void setUser(User user) {
        this.user = user;
    }
}
