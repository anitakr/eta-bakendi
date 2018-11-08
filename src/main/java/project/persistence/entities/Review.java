package project.persistence.entities;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private long id;

    private int rating;
    private String text;
    private String username;
    @ManyToOne(cascade = CascadeType.ALL)
    private Restaurant restaurant;


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
