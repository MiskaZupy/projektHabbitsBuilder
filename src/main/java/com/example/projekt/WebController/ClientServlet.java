package com.example.projekt.WebController;

import com.example.projekt.Entities.Habit;
import com.example.projekt.Entities.User;
import com.example.projekt.Repository.UserRepository;
import com.example.projekt.Service.HabitService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
    private final UserRepository userRepo;
    private final HabitService habitService;

    public ClientServlet(UserRepository userRepo, HabitService habitService) {
        this.userRepo = userRepo;
        this.habitService = habitService;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        String login = request.getParameter("login");
        User USER = userRepo.findTopByName(login);

        Long id = USER.getId();
        LocalDate date = LocalDate.now();
        Iterable<Habit> habits = habitService.findAllByUserTime(userRepo.getById(id),date);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ClientPage.jsp");
        request.setAttribute("habits",  habits);
        dispatcher.forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {


        try {

            // odczytanie zadania
            String command = request.getParameter("command");

            if (command == null)
                command = "LIST";


            switch (command) {
                case "UPDATE" -> update(request, response);
                case "DELETE" -> delete(request, response);
                case "ADD" -> add(request,response);
                default -> list(request, response);
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Long id = Long.getLong(request.getParameter("id"));

        String name = request.getParameter("name");
        String days = request.getParameter("days");
        String time = request.getParameter("appt");
        String howLong = request.getParameter("time");
        LocalDate date = LocalDate.now();

        Map<String,Object>map = Map.of("name", name,"todoTime", date,"time",time);

        habitService.partialUpdateById(id,map);
        list(request,response);
    }


    private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Long id = Long.getLong(request.getParameter("id"));
        habitService.deleteById(id);

        list(request,response);

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String name = request.getParameter("name");
        String days = request.getParameter("days");
        String time = request.getParameter("appt");
        String howLong = request.getParameter("time");
        String desribtion ="";
        LocalDate date = LocalDate.now();
        int points = 0;
        String status ="";
        Habit habit = new Habit(name,desribtion,date,points,status);
        habitService.save(habit);

        list(request,response);

    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // request.setAttribute("habits", );
        // request.setAttribute("weeklyHabits", );


        RequestDispatcher dispatcher = request.getRequestDispatcher("/ClientPage.jsp");

        dispatcher.forward(request, response);

    }

}
