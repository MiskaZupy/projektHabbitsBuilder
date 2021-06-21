package com.example.projekt.Controller;


import com.example.projekt.Entities.User;
import com.example.projekt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
    public class MainController {
    @Autowired
    private UserRepository repo;

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
        public String clientPage() {

            return "ClientPage";
        }

        @GetMapping("/ClientServlet")
        public  String clientServlet(){
            return "ClientServlet";
        }



        @PostMapping("/process_register")
        public String processRegistration(User user){
            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
            String encodecPassword=encoder.encode(user.getPassword());
            user.setPassword(encodecPassword);
            repo.save(user);
            return "ClientPage";

        }
}

