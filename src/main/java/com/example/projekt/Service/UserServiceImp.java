package com.example.projekt.Service;

import com.example.projekt.Entities.Role;
import com.example.projekt.Entities.User;
import com.example.projekt.Repository.UserRepository;
import com.example.projekt.dto.RegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.stream.Collectors;


public class UserServiceImp implements UserService{
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(RegistrationDTO registrationDto) {
        User user = new User(registrationDto.getEmail()
                , registrationDto.getName(),
                passwordEncoder.encode(registrationDto.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
