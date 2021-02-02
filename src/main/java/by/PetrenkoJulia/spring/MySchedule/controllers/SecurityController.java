package by.PetrenkoJulia.spring.MySchedule.controllers;

import by.PetrenkoJulia.spring.MySchedule.entities.Task;
import by.PetrenkoJulia.spring.MySchedule.entities.User;
import by.PetrenkoJulia.spring.MySchedule.services.TaskService;
import by.PetrenkoJulia.spring.MySchedule.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@RestController
public class SecurityController {
    private UserService userService;
    private TaskService taskService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String ScheduleForAll(){
        return "home";
    }

    @GetMapping("/tasks")
    public Collection<Task> ShowTasks(Principal principal){
        return userService.TasksByUser(principal.getName());
    }

    @PostMapping("/add")
    public void AddTask(@RequestParam("name") String name){
        taskService.CreateTask(name);
    }

}
