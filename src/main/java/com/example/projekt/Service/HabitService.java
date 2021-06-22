package com.example.projekt.Service;

import com.example.projekt.Entities.Habit;
import com.example.projekt.Repository.HabbitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projekt.Entities.User;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@Service
public class HabitService {

    private HabbitsRepository habitRepo;

    @Autowired
    public HabitService(HabbitsRepository habitRepo) {
        this.habitRepo = habitRepo;
    }


    public Optional<Habit> findById(Long id) {
        return habitRepo.findById(id);
    }

    public Iterable<Habit> findAll() {
        return habitRepo.findAll();
    }

    public Iterable<Habit> findAllByUser(User user) {return habitRepo.getByUser(user);}

    public Iterable<Habit> findAllByUserTime(User user, LocalDate time) {return habitRepo.getAllByUserAndTodoTime(user,time);}




    public Habit save(Habit habit) {
        return habitRepo.save(habit);
    }

    public void deleteById(Long id) {
        habitRepo.deleteById(id);
    }

    public Habit partialUpdateById(Long id, Map<String, Object> updates) {
        Habit habit = findById(id).get();

        if (updates.containsKey("status")) {
            habit.setStatus(updates.get("status").toString());
        } else if (updates.containsKey("name")) {
            habit.setName(updates.get("name").toString());
        } else if (updates.containsKey("toDoTime")) {
            habit.setTodoTime(LocalDate.parse(updates.get("toDoTime").toString()));
        }else if (updates.containsKey("description")){
            habit.setDescription(updates.get("description").toString());
        }
        return habitRepo.save(habit);
    }


}
