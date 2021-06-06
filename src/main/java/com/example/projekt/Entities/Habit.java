package com.example.projekt.Entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "habits_table")
public class Habit {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDateTime todoTime;
    private String status;

    @OneToMany(mappedBy = "users")
    Set<User> userSet;

    public Habit() {}

    public Habit(Long id, String name, String description, LocalDateTime todoTime, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.todoTime = todoTime;
        this.status =  status;
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

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public LocalDateTime getTodoTime() { return todoTime; }

    public void setTodoTime(LocalDateTime todoTime) { this.todoTime = todoTime; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
