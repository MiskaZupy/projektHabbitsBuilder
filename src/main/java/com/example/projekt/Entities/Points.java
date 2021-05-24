package com.example.projekt.Entities;

import javax.persistence.*;

@Entity
public class Points {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    Checkins checkins;

    private int value;

    public Points() {}




}
