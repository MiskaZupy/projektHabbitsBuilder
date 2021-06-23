package com.example.projekt.Repository;

import com.example.projekt.Entities.Checkins;
import com.example.projekt.Entities.Habit;
import com.example.projekt.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CheckinsRepository extends CrudRepository<Checkins, Long> {

    @Query("SELECT u FROM Checkins u WHERE u.user = ?1")
    public Iterable<Checkins> getAllByUser(Long idUser);

    public List<Checkins> getByUser(User user);

}
