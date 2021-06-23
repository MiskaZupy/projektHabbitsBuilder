package com.example.projekt.WebController;

import com.example.projekt.Entities.Habit;
import com.example.projekt.Repository.UserRepository;
import com.example.projekt.Service.HabitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import java.time.LocalDate;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/ClientPage")
public class ClientController {


    private final UserRepository userRepo;
    private final HabitService habitService;


    public ClientController( UserRepository userRepo, HabitService habitService){

        this.userRepo = userRepo;
        this.habitService = habitService;
    }


    @GetMapping("/ClientPage")
    public String viewBooks(Model model,Long id) {

        LocalDate date = LocalDate.now();


        return "ClientPage";
    }

    @GetMapping("/addHabit")
    public String addHabitView(Model model) {
        model.addAttribute("habit", new Habit());
        return "addHabit";
    }

    @PostMapping("/addHabit")
    public RedirectView addHabit(@ModelAttribute("habit") Habit habit, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/addHabit/habit", true);
        Habit savedHabit = habitService.save(habit);
        redirectAttributes.addFlashAttribute("savedHabit", savedHabit);
        redirectAttributes.addFlashAttribute("addHabitSuccess", true);
        return redirectView;
    }


}
