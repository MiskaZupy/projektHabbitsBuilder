package com.example.projekt.Entities;

import javax.persistence.*;

@Entity
@Table(name = "habits")
public class UserHabbits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("id")
    User user;

    @ManyToOne
    @MapsId("id")
    Habit habit;


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

    public Habit getHabits() {
        return habit;
    }

    public void setHabits(Habit habit) {
        this.habit = habit;
    }
}
