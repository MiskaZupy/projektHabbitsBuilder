package com.example.projekt.Entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "habits")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhabits", nullable = false, unique = true, length = 45)
    private Long id;
    @Column(name = "name", nullable = false, unique = true, length = 45)
    private String name;
    @Column(name = "description", nullable = false, unique = true, length = 45)
    private String description;
    @Column(name = "date", nullable = false, unique = true, length = 45)
    private LocalDate todoTime;
    @Column(name = "time", nullable = false, unique = true, length = 45)
    private LocalTime time;
    @Column(name = "status", nullable = false, unique = true, length = 45)
    private String status;
    @Column(name = "points", nullable = false, unique = true, length = 45)
    private int points;

    @ManyToMany
    @JoinColumn(name = "idUser")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(name = "idUser", nullable = false, unique = true, length = 45)
    private Set<User> user=new HashSet<>();

    public Habit() {
    }

    public Habit( String name, String description, LocalDate todoTime, int points, String status) {
        this.name = name;
        this.description = description;
        this.todoTime = todoTime;
        this.points = points;
        this.status = status;
    }

    public Habit(String name, String description, LocalDate todoTime, int points, String status,Set<User> user) {
        this.name = name;
        this.description = description;
        this.todoTime = todoTime;
        this.points = points;
        this.status = status;
        this.user = user;
    }
    public Habit(Long id, String name, String description, LocalDate todoTime, LocalTime time, String status, int points) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.todoTime = todoTime;
        this.time = time;
        this.status = status;
        this.points = points;
    }

    public Habit(Long id, String name, String description, LocalDate todoTime, LocalTime time, String status, int points, Set<User> user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.todoTime = todoTime;
        this.time = time;
        this.status = status;
        this.points = points;
        this.user = user;
    }




    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public LocalDate getTodoTime() {
        return todoTime;
    }

    public void setTodoTime(LocalDate todoTime) {
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
