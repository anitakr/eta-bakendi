package project.persistence.entities;

import ch.qos.logback.classic.db.names.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;


public class Tag {
    //    private long id;
    private String tag;
//    @ManyToOne
//    private List<Restaurant> restaurants;

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

//    public List<Restaurant> getRestaurants() {
//        return restaurants;
//    }
//
//    public void setRestaurants(List<Restaurant> restaurants) {
//        this.restaurants = restaurants;
//    }
}
