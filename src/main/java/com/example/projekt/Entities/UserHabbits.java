package com.example.projekt.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserHabbits {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("id")
    User user;

    @ManyToOne
    @MapsId("id")
    Habits habits;




    public UserHabbits() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Habits getHabits() {
        return habits;
    }

    public void setHabits(Habits habits) {
        this.habits = habits;
    }
}
