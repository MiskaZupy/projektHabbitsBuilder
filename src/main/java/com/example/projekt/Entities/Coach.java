package com.example.projekt.Entities;

import javax.persistence.*;

@Entity
@Table(name = "coachhabits")
public class Coach {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private int points;
    private String description;

    public Coach(Long id, String name, int points, String description) {
        this.id = id;
        this.name = name;
        this.points = points;
        this.description = description;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Coach() {}





}
