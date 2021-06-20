package com.example.projekt.Service;

import com.example.projekt.Entities.Coach;
import com.example.projekt.Entities.Habit;
import com.example.projekt.Repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {
    public CoachRepository coachRepository;
    @Autowired
    public CoachService (CoachRepository coachRepository){this.coachRepository = coachRepository;}
    public Iterable<Coach> findAll() {return coachRepository.findAll(); }
//    @Query("select p.id from #{coachhabits} p")
//    public List<Long> getAllIds(){};

}
