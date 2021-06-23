package com.example.projekt.Entities;

import javax.persistence.*;


@Entity
public class Points {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idpoints", nullable = false, unique = true, length = 45)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;
    @Column(name = "value" )
    public int value;

    public Points() {}


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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
