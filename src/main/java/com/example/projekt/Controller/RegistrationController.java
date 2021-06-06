package com.example.projekt.Controller;

import com.example.projekt.Service.UserService;
import com.example.projekt.dto.RegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {


    private UserService userService;
//
//
//    public RegistrationController(UserService userService) {
//        this.userService = userService;
//    }

    @ModelAttribute("user")
    public RegistrationDTO userRegistrationDto() {
        return new RegistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") RegistrationDTO registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}

