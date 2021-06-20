package com.example.projekt.Repository;

import com.example.projekt.Entities.Checkins;
import com.example.projekt.Entities.UserHabbits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.projekt.Entities.User;

@Repository
public interface UserHabitsRepository extends CrudRepository<UserHabbits, Long> {

    Iterable<UserHabbits> findUserHabbitsByUser(User user);

}
