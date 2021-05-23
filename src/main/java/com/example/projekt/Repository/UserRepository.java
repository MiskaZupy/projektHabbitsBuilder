package com.example.projekt.Repository;

import com.example.projekt.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

        User findByEmail(String email);
    }

