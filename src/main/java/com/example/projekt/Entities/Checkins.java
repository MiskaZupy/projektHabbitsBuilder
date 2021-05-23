package com.example.projekt.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Checkins {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private LocalDate checkinDate;



    private Long habbitsID; // 1 habbit to many checkins
    private Long userID;  // 1 user to many checkins




    public Checkins() {}




}
