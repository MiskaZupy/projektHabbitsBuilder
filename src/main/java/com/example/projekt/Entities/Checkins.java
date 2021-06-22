package com.example.projekt.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "checkins")
public class Checkins {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idcheckin", nullable = false, unique = true, length = 45)
    private Long idCheckin;

    @Column(name = "date_checkin", nullable = false, length = 45)
    private LocalDate dateCheckin;

    @ManyToOne
    @JoinColumn
    private Habit habits; // 1 habbit to many checkins
    @ManyToOne
    @JoinColumn
    private User user;  // 1 user to many checkins




    public Checkins() {}

    public Long getId() {
        return idCheckin;
    }

    public void setId(Long id) {
        this.idCheckin = id;
    }

    public LocalDate getCheckinDate() {
        return dateCheckin;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.dateCheckin = checkinDate;
    }

    public Habit getHabbitsID() {
        return habits;
    }

    public void setHabbitsID(Habit habbitsID) {
        this.habits = habbitsID;
    }

    public User getUserID() {
        return user;
    }

    public void setUserID(User userID) {
        this.user = userID;
    }
}

