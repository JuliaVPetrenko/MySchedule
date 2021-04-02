package by.PetrenkoJulia.spring.MySchedule.controllers;

import by.PetrenkoJulia.spring.MySchedule.entities.Task;
import by.PetrenkoJulia.spring.MySchedule.entities.User;
import by.PetrenkoJulia.spring.MySchedule.services.TaskService;
import by.PetrenkoJulia.spring.MySchedule.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.security.Principal;
import java.util.*;

@RestController
public class Controller {
    private UserService userService;
    private TaskService taskService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public Iterable<User> ScheduleForAll(){
        return userService.ShowAllUsers();
    }

    @GetMapping("/all_tasks")
    public ResponseEntity<List<Task>> ShowAllTasks() {
        List<Task> tasks = taskService.TasksShow();
        if (tasks.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(tasks);
    }

//    public String ShowAllTasks(){
//        Iterable<Task> tasks = taskService.TasksShow();
//        List<Task> listTask = (List) tasks;
//        return listTask.stream().map(task -> task.getName()).reduce((t, s) -> t + "<br>" + s).get();
//    }

//    @GetMapping("/tasks")
//    public Collection<Task> ShowTasks(Principal principal){
////    public Collection<Task> ShowTasks(Principal principal){
//        return userService.TasksByUser(principal.getName());
//    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> ShowTasksById(@PathVariable("id") Long id){
//    public Collection<Task> ShowTasks(Principal principal){
        Task task = taskService.getById(id);
        if (task == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(task);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Task> EditTasksById(@PathVariable("id") Long id, @RequestBody Task newTask){
        if (taskService.getById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Task task = taskService.updateTask(id, newTask);
        return ResponseEntity.ok(task);
    }

    @PostMapping("/add_task")
//    @RequestMapping(value ="/add_task", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> AddTask(@RequestBody Task task){
        HttpHeaders headers = new HttpHeaders();
        if(task == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        taskService.saveTask(task);
        return new ResponseEntity<>(task, headers, HttpStatus.CREATED);
    }

    @PostMapping("/add_user")
    public User AddUser(@RequestBody @Valid User user){
        return userService.saveUser(user);
    }

}
