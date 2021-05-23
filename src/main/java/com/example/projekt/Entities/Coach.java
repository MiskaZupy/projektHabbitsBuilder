package com.example.projekt.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coach {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    public Coach() {}





}
