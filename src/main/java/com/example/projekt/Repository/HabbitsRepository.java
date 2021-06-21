package com.example.projekt.Repository;

import com.example.projekt.Entities.Habit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.projekt.Entities.User;
import java.time.LocalDate;

@Repository
public interface HabbitsRepository extends CrudRepository<Habit, Long> {

    public Iterable<Habit> getAllByUser(User user);

    public Iterable<Habit> getAllByUserAndTodoTime(User user,LocalDate time);

}

