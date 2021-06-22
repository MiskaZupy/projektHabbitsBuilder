package com.example.projekt.Coach;


import com.example.projekt.Entities.Coach;
import com.example.projekt.Entities.Habit;
import com.example.projekt.Entities.User;
import com.example.projekt.Repository.CoachRepository;
import com.example.projekt.Service.CoachService;
import com.example.projekt.Service.HabitService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;

@Service
public class HabitGenerator {
    @Autowired
    private HabitService habitService;

    @Autowired
    private CoachService coachService;

    private boolean checkIfNotEmpty (User user){
        // todo conect habits with users
        return IterableUtils.size(habitService.findAllByUser(user)) == 0;
    }
    private Iterable<Coach> getCoachHabList() { return  coachService.findAllHabs();}

    public void addAddIfEmpty(User user) throws Exception {
        List<Coach> hab_list = (List<Coach>) getCoachHabList();
        List<Long> id_list = new ArrayList<>();
        for (Coach h : hab_list ){
            id_list.add(h.getId());
        }
        if(checkIfNotEmpty(user)){
            Random random =  new Random();
            Long id = id_list.get(random.nextInt(id_list.size()));
             coachService.findById(id);
            if (coachService.findById(id).isPresent()){
                Coach coachHab =  coachService.findById(id).get();
                  habitService.save(new Habit(coachHab.getName(),coachHab.getDescription(),
                           (LocalDate.now().plusDays(3)).toString(),"12:00", "undone",coachHab.getPoints(), user));
            }else {
                throw new Exception("Błąd przy losowaniu habitu");
            }
        }
    }
}
