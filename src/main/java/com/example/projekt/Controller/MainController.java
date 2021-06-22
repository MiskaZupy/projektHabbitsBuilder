package com.example.projekt.Controller;


import com.example.projekt.Entities.Habit;
import com.example.projekt.Entities.User;
import com.example.projekt.Repository.HabbitsRepository;
import com.example.projekt.Repository.UserRepository;
import com.example.projekt.Service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.rmi.MarshalledObject;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

@Controller
    public class MainController {
    @Autowired
    private UserRepository repo;
    @Autowired
    private HabbitsRepository habitRepo;


        @GetMapping("/login")
        public String login() {
            return "login";
        }

        @GetMapping("/index")
        public String home() {
            return "index";
        }

        @GetMapping("/register")
        public String showSignUpForm (Model model) {

            model.addAttribute("user", new User());
            return "register";
        }



        @GetMapping("/ClientPage")
        public String clientPage(@AuthenticationPrincipal User user, Model model) {
            model.addAttribute("user", user);
            Iterable<Habit> habit = habitRepo.getByUser(user);
            model.addAttribute("habit", habit);

            return "ClientPage";
        }



        @PostMapping("/process_register")
        public String processRegistration(User user){
            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
            String encodecPassword=encoder.encode(user.getPassword());
            user.setPassword(encodecPassword);
            repo.save(user);
            return "login";

        }
}

