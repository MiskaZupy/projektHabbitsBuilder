package com.example.projekt.Service;

import com.example.projekt.Entities.User;
import com.example.projekt.dto.RegistrationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(RegistrationDTO registrationDto);
}