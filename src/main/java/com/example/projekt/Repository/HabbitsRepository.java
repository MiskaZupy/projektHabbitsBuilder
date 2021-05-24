package com.example.projekt.Repository;

import com.example.projekt.Entities.Habits;
import com.example.projekt.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabbitsRepository extends CrudRepository<Habits, Long> {

}

