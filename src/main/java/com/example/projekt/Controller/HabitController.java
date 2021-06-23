package com.example.projekt.Controller;

import com.example.projekt.Entities.Coach;
import com.example.projekt.Entities.Habit;
import com.example.projekt.Service.CoachService;
import com.example.projekt.Service.HabitService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HabitController {

    private HabitService habitService;
    private CoachService coachService;

    @Autowired
    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping("user/habit/all")
    public Iterable<Habit>getAllHabits(){return habitService.findAll();}

    @GetMapping("user/habit")
    public Optional <Habit> getHabitById(@RequestParam Long id){return  habitService.findById(id);}

    @PostMapping("user/habit")
    @JsonFormat(pattern="yyyy-MM-dd")
    public Habit addHabit(@RequestBody Habit habit){ return habitService.save(habit);}

    @PutMapping("coach/habit")
    public Habit updateHabit(@RequestParam Habit habit){return  habitService.save(habit);}

    @PatchMapping("user/habit/{id}")
    public  Habit updateUserHabit (@RequestBody Map<String, Object>updates, @PathVariable("id")Long id){
        if(habitService.partialUpdateById(id, updates) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no such task");
        }
        else {
            return habitService.partialUpdateById(id, updates);
        }
    }

    @DeleteMapping("user/habit")
    public void deleteHabitById (@RequestParam Long id){
        habitService.deleteById(id);
    }

    @GetMapping("user/habit/coach")
    public Iterable<Coach> getCoachHabit(){return coachService.findAll();}

}
