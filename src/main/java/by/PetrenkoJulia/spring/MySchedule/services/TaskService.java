package by.PetrenkoJulia.spring.MySchedule.services;

import by.PetrenkoJulia.spring.MySchedule.entities.Task;
import by.PetrenkoJulia.spring.MySchedule.entities.User;
import by.PetrenkoJulia.spring.MySchedule.repository.TaskRepository;
import by.PetrenkoJulia.spring.MySchedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> TasksShow(){
        return taskRepository.findAll();
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }
}
