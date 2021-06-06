package com.example.projekt.Entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "habits")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDateTime todoTime;
    private String status;
    private int points;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
//    private Set<User> userSet;

    public Habit() {
    }

    public Habit(Long id, String name, String description, LocalDateTime todoTime, int points, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.todoTime = todoTime;
        this.points = points;
        this.status = status;
    }

    public Habit(String name, String description, LocalDateTime todoTime, int points, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.todoTime = todoTime;
        this.points = points;
        this.status = status;
    }

        public Habit(String name, String description, LocalDateTime todoTime, String status, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.todoTime = todoTime;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTodoTime() {
        return todoTime;
    }

    public void setTodoTime(LocalDateTime todoTime) {
        this.todoTime = todoTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
