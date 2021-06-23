package com.example.projekt.Repository;

import com.example.projekt.Entities.Habit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.projekt.Entities.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface HabbitsRepository extends CrudRepository<Habit, Long> {

    public List<Habit> getByUser(User user);
    public List<Habit> getById(Long id);



    Habit getHabitById(Long id);
}

