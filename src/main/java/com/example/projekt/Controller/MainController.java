package com.example.projekt.Controller;


import com.example.projekt.Coach.HabitGenerator;
import com.example.projekt.Entities.Checkins;
import com.example.projekt.Entities.Habit;
import com.example.projekt.Entities.Points;
import com.example.projekt.Entities.User;
import com.example.projekt.Repository.CheckinsRepository;
import com.example.projekt.Repository.HabbitsRepository;
import com.example.projekt.Repository.PointsRepository;
import com.example.projekt.Repository.UserRepository;
import com.example.projekt.Service.CheckinsService;
import com.example.projekt.Service.CustomUserDetails;
import com.example.projekt.Service.HabitService;
import com.example.projekt.Service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    private UserRepository repo;
    @Autowired
    private HabbitsRepository habitRepo;
    @Autowired
    private HabitGenerator habitGenerator;
    @Autowired
    private CheckinsRepository checkinsRepository;
    @Autowired
    private PointsRepository pointsRepository;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/addHabit")
    public String addHabit(Model model) {
        model.addAttribute("habit", new Habit());
        return "addHabit";
    }

    @GetMapping("/register")
    public String showSignUpForm (Model model) {

        model.addAttribute("user", new User());
        return "register";
    }



    @GetMapping("/ClientPage")
    public String clientPage(@AuthenticationPrincipal CustomUserDetails user, Model model) throws Exception {
//
        model.addAttribute("user", user);
        User user1=repo.findByEmail(user.getUsername());
        Iterable<Habit> habit = habitRepo.getByUser(user1);
        model.addAttribute("habit", habit);
        habitGenerator.addAddIfEmpty(user1);

        return "ClientPage";
    }
    @GetMapping("/clientPrizes")
    public String clientPrizes(@AuthenticationPrincipal CustomUserDetails user, Model model) throws Exception {
//
        model.addAttribute("user", user);
        User user1=repo.findByEmail(user.getUsername());
        Iterable<Checkins> checkins = checkinsRepository.getByUser(user1);
        Iterable<Points> points=pointsRepository.getByUser(user1);
        model.addAttribute("points",points);
        model.addAttribute("checkins", checkins);


        return "clientPrizes";
    }


    @GetMapping("/error")
    public String error(){return "error";}

    @PostMapping("/process_register")
    public String processRegistration(User user){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String encodecPassword=encoder.encode(user.getPassword());
        user.setPassword(encodecPassword);
        repo.save(user);
        return "index";

    }

    @PostMapping("/proces_add")
    public String processAdd(@AuthenticationPrincipal CustomUserDetails user, Habit habit , Model model){
        User user1=repo.findByEmail(user.getUsername());
        habit.setStatus("undone");
        habit.setUser(user1);
        habitRepo.save(habit);
        model.addAttribute("user", user);
        Iterable<Habit> habit1 = habitRepo.getByUser(user1);
        model.addAttribute("habit", habit1);
        return "ClientPage";

    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteHabit(@PathVariable Long id,@AuthenticationPrincipal CustomUserDetails user, Model model ) {
        User user1=repo.findByEmail(user.getUsername());
        habitRepo.deleteById(id);
        model.addAttribute("user", user);
        Iterable<Habit> habit = habitRepo.getByUser(user1);
        model.addAttribute("habit", habit);
        return "ClientPage";

    }
    @PatchMapping("/modifyThisHabit/{id}")
    public String patchHabit(@AuthenticationPrincipal CustomUserDetails user, @PathVariable Long id, Habit habit, Model model){


        habit.setId(id);
        User user1=repo.findByEmail(user.getUsername());



        habit.setUser( user1);
        habitRepo.save(habit);

        model.addAttribute("user", user);
        Iterable<Habit> habit1 = habitRepo.getByUser(user1);
        model.addAttribute("habit", habit1);

        return "ClientPage";
    }
    @GetMapping("/modifyHabit/{id}")
    public String modelHabit(@PathVariable Long id, Model model) {
        Habit habit = habitRepo.getHabitById(id);
        model.addAttribute("habit", habit);
        return "modifyHabit";

    }


}