package by.PetrenkoJulia.spring.MySchedule.services;

import by.PetrenkoJulia.spring.MySchedule.entities.Task;
import by.PetrenkoJulia.spring.MySchedule.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public List<Task> tasksShow(){
        return taskRepository.findAll();
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Collection<Task> tasksByUserName(String userName){
        Collection<Task> tasks = taskRepository.findByUsersIsContaining(userService.findByUsername(userName));
        return tasks;
    }

    public Task updateTask (Long id, Task newTask){
        Task taskToUpdate = getTaskById(id);
        taskToUpdate.setTaskname(newTask.getTaskname());
        taskToUpdate.setPriority(newTask.getPriority());
        taskToUpdate.setDate_create(newTask.getDate_create());
        taskToUpdate.setDate_start(newTask.getDate_start());
        taskToUpdate.setUsers(newTask.getUsers());

        return taskRepository.save(taskToUpdate);
    }

    public Task patchTask(Long id, Task newTask){
        Task taskToUpdate = getTaskById(id);

        if (newTask.getTaskname() != null && !newTask.getTaskname().trim().isEmpty()) {
            taskToUpdate.setTaskname(newTask.getTaskname());
        }
        if (newTask.getPriority() != null && newTask.getPriority()>0) {
            taskToUpdate.setPriority(newTask.getPriority());
        }
        if (newTask.getDate_create() != null) {
            taskToUpdate.setDate_create(newTask.getDate_create());
        }
        if (newTask.getDate_start() != null) {
            taskToUpdate.setDate_start(newTask.getDate_start());
        }
        if (newTask.getUsers() != null) {
            taskToUpdate.setUsers(newTask.getUsers());
        }

        return taskRepository.save(taskToUpdate);
    }

    private boolean isBlank(String str){
        if (str != null && !str.trim().isEmpty()) {
            return true;
        }
        return false;
    }

}
