package com.example.projekt.Coach;


import com.example.projekt.Entities.Habit;
import com.example.projekt.Entities.User;
import com.example.projekt.Service.HabitService;

public class HabitGenerator {
    private HabitService habitService;

    private boolean checkIfNotEmpty (User user){
        return habitService.findAllByUser(user) == null;
    }

    private void addAddIfNotHabit(User user){
        if(checkIfNotEmpty(user) == true){
            int random_id =(int)(Math.random() * 10);

        }else {
            // do nothing
        }
    }

}
