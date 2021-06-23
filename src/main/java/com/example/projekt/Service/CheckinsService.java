package com.example.projekt.Service;

import com.example.projekt.Entities.Checkins;
import com.example.projekt.Repository.CheckinsRepository;
import com.example.projekt.Repository.HabbitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
@Service
public class CheckinsService {

    private CheckinsRepository checkinRepo;

    @Autowired
    public CheckinsService(CheckinsRepository checkinRepo) {
        this.checkinRepo = checkinRepo;
    }

    public Optional<Checkins> findById(Long id) {
        return checkinRepo.findById(id);
    }

    public Iterable<Checkins> findAll() {
        return checkinRepo.findAll();
    }

    public Iterable<Checkins> findAllByUser(Long id) {return checkinRepo.getAllByUser(id);}

    public Checkins save(Checkins checkin) {
        return checkinRepo.save(checkin);
    }

    public void deleteById(Long id) {
        checkinRepo.deleteById(id);
    }



}

