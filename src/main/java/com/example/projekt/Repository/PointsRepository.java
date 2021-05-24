package com.example.projekt.Repository;

import com.example.projekt.Entities.Points;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PointsRepository extends CrudRepository<Points, Long> {

}
