package com.example.projekt.Repository;

import com.example.projekt.Entities.Points;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PointsRepository extends CrudRepository<Points, Long> {
    @Query("SELECT u FROM Points u WHERE u.user = ?1")
    public Iterable<Points> getAllByUser(Long idUser);

}
