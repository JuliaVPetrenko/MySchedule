package by.PetrenkoJulia.spring.MySchedule.controllers;

import by.PetrenkoJulia.spring.MySchedule.entities.Task;
import by.PetrenkoJulia.spring.MySchedule.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ScheduleController {

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/show_all")
    public String ShowAll(){
        Iterable<Task> tasks = taskService.TasksShow();
        List<Task> listTask = (List) tasks;
        return listTask.stream().map(task -> task.getName()).reduce((t, s) -> t + "<br>" + s).get();
    }

//    @GetMapping("/{id}")
//    public String tasksShowForUser(@PathVariable("id") int id) {
//        List<Task> tasks = taskService.tasksShowForUser(id);
//        return tasks.stream().map(task -> task.getName()).reduce((t, s) -> t + "<br>" + s).get();
//    }




}

//    public Person show(int id) {
//        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
//    }