package com.example.projekt.Repository;

import com.example.projekt.Entities.Coach;
import com.example.projekt.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoachRepository extends CrudRepository<Coach, Long> {
    @Query("SELECT c.id FROM Coach c ")
    Iterable<Long> getAllIds();
}
