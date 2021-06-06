package com.example.projekt.Repository;

import com.example.projekt.Entities.Habit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabbitsRepository extends CrudRepository<Habit, Long> {

}

