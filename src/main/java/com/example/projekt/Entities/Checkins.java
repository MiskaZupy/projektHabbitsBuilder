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
    public LocalDate dateCheckin;

    @ManyToOne
    @JoinColumn
    public Habit habits;
    @ManyToOne
    @JoinColumn
    private User user;




    public Checkins() {}

    public Checkins(Long idCheckin, LocalDate dateCheckin, Habit habits, User user) {
        this.idCheckin = idCheckin;
        this.dateCheckin = dateCheckin;
        this.habits = habits;
        this.user = user;
    }

    public Long getId() {
        return idCheckin;
    }

    public void setId(Long id) {
        this.idCheckin = id;
    }

    public LocalDate getCheckinDate() {
        return dateCheckin;
    }

    public void setCheckinDate(LocalDate dateCheckin) {
        this.dateCheckin = dateCheckin;
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

