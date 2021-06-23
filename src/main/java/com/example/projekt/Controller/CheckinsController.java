package com.example.projekt.Controller;

import com.example.projekt.Entities.Checkins;
import com.example.projekt.Entities.Coach;
import com.example.projekt.Entities.Habit;
import com.example.projekt.Service.CheckinsService;
import com.example.projekt.Service.CoachService;
import com.example.projekt.Service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CheckinsController {

    private HabitService habitService;
    private CheckinsService checkinsService;

    @Autowired
    public CheckinsController(CheckinsService checkinsService) {
        this.checkinsService = checkinsService;
    }

    @GetMapping("user/checkins/all")
    public Iterable<Checkins> getAllCheckins() {
        return checkinsService.findAll();
    }

    @GetMapping("user/checkins")
    public Optional<Checkins> getCheckinById(@RequestParam Long id) {
        return checkinsService.findById(id);
    }
    @GetMapping("user/checkins/id")
    public Iterable<Checkins> getCheckinByUser(@RequestParam Long id) {
        return checkinsService.findAllByUser(id);
    }


}
