package com.example.projekt.Service;

import com.example.projekt.Entities.Checkins;
import com.example.projekt.Entities.Points;
import com.example.projekt.Repository.CheckinsRepository;
import com.example.projekt.Repository.PointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PointsService {

    private PointsRepository pointsRepository;

    @Autowired
    public PointsService(PointsRepository pointsRepository) {
        this.pointsRepository=pointsRepository;
    }

    public Optional<Points> findById(Long id) {
        return pointsRepository.findById(id);
    }

    public Iterable<Points> findAll() {
        return pointsRepository.findAll();
    }

    public Iterable<Points> findAllByUser(Long id) {return pointsRepository.getAllByUser(id);}

    public void deleteById(Long id) {
        pointsRepository.deleteById(id);
    }

}
