package com.example.projekt.Controller;

import com.example.projekt.Entities.Checkins;
import com.example.projekt.Entities.Points;
import com.example.projekt.Service.CheckinsService;
import com.example.projekt.Service.HabitService;
import com.example.projekt.Service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PointsController {

    private HabitService habitService;
    private PointsService pointsService;

    @Autowired
    public PointsController(PointsService pointsService) {
        this.pointsService = pointsService;
    }

    @GetMapping("user/points/all")
    public Iterable<Points> getAllPoints() {
        return pointsService.findAll();
    }

    @GetMapping("user/points")
    public Optional<Points> getPointsById(@RequestParam Long id) {
        return pointsService.findById(id);
    }
    @GetMapping("user/points/id")
    public Iterable<Points> getPointsByUser(@RequestParam Long id) {
        return pointsService.findAllByUser(id);
    }


    @DeleteMapping("user/points")
    public void deletePointsById(@RequestParam Long id) {
        pointsService.deleteById(id);
    }

}
