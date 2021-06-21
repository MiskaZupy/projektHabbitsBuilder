package com.example.projekt.Coach;


import com.example.projekt.Entities.Coach;
import com.example.projekt.Entities.Habit;
import com.example.projekt.Entities.User;
import com.example.projekt.Repository.CoachRepository;
import com.example.projekt.Service.CoachService;
import com.example.projekt.Service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class HabitGenerator {

    private HabitService habitService;

    @Autowired
    private CoachService coachService;

    private boolean checkIfNotEmpty (User user){
        return habitService.findAllByUser(user) == null;
    }
    private Iterable<Long> getIDList() { return  coachService.findAllHabs();}

    public void addAddIfEmpty(User user) throws Exception {
        List<Long> id_list = (List<Long>) getIDList();
        if(checkIfNotEmpty(user)){
            Random random =  new Random();
            Long id = id_list.get(random.nextInt(id_list.size()));
            if (coachService.findById(id).isPresent()){
                Coach coachHab = coachService.findById(id).get();
                   Habit newHabit = new Habit(coachHab.getName(),coachHab.getDescription(),
                           LocalDate.now().plusDays(3), coachHab.getPoints(), "undone");
                   habitService.save(newHabit);
            }else {
                throw new Exception("Błąd przy losowaniu habitu");
            }
        }
    }
}
