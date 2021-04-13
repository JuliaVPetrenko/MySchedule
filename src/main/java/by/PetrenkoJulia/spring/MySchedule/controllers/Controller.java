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
    public Iterable<User> scheduleForAll(){
        return userService.ShowAllUsers();
    }

    @GetMapping("/all_tasks")
    public ResponseEntity<List<Task>> showAllTasks() {
        List<Task> tasks = taskService.tasksShow();
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

    @GetMapping("/tasks")
    public Collection<Task> showTasks(Principal principal){
        return taskService.tasksByUserName(principal.getName());
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> showTasksById(@PathVariable("id") Long id){
//    public Collection<Task> ShowTasks(Principal principal){
        Task task = taskService.getTaskById(id);
        if (task == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping("/add_task")
//    @RequestMapping(value ="/add_task", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        if(task == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        taskService.saveTask(task);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Task> editTasksById(@PathVariable("id") Long id, @RequestBody Task newTask){
        if (taskService.getTaskById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Task task = taskService.updateTask(id, newTask);
        return ResponseEntity.ok(task);
    }

    @PatchMapping("task/{id}")
    public ResponseEntity<Task> patchTaskById(@PathVariable("id") Long id, @RequestBody Task newTask){
        if (taskService.getTaskById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Task task = taskService.patchTask(id, newTask);
        return ResponseEntity.ok(task);
    }

    @PostMapping("/add_user")
    public ResponseEntity<User> addUser(@RequestBody @Valid User newUser){
        if(newUser == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        User user = userService.saveUser(newUser);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<User> editUserById(@PathVariable("id") Long id, @RequestBody User newUser){
        if (userService.getUserById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        User user = userService.updateUser(id, newUser);
        return ResponseEntity.ok(user);
    }

}
