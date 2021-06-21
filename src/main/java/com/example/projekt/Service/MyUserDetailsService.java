package com.example.projekt.Service;


import com.example.projekt.Coach.HabitGenerator;
import com.example.projekt.Entities.User;
import com.example.projekt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private HabitGenerator habitGenerator = new HabitGenerator();

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
//        try {
//            habitGenerator.addAddIfEmpty(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
