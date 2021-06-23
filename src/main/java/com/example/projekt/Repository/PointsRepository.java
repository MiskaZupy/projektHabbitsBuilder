package com.example.projekt.Repository;

import com.example.projekt.Entities.Checkins;
import com.example.projekt.Entities.Points;
import com.example.projekt.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointsRepository extends CrudRepository<Points, Long> {
    @Query("SELECT u FROM Points u WHERE u.user = ?1")
    public Iterable<Points> getAllByUser(Long idUser);

    public List<Points> getByUser(User user);




}
