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

    public Task getById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Collection<Task> TasksByUserName(String userName){
        Collection<Task> tasks = taskRepository.findByUsersIsContaining(userService.findByUsername(userName));
        return tasks;
    }

    public Task updateTask (Long id, Task newTask){
        Task taskToUpdate = getById(id);
        taskToUpdate.setName(newTask.getName());
        taskToUpdate.setPriority(newTask.getPriority());
        taskToUpdate.setDate_create(newTask.getDate_create());
        taskToUpdate.setDate_start(newTask.getDate_start());
        taskToUpdate.setUsers(newTask.getUsers());

        return taskRepository.save(taskToUpdate);
    }

    public Task patchTask(Long id, Task task){
        return null;
    }

}
