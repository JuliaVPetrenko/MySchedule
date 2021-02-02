package by.PetrenkoJulia.spring.MySchedule.services;

import by.PetrenkoJulia.spring.MySchedule.entities.Task;
import by.PetrenkoJulia.spring.MySchedule.entities.User;
import by.PetrenkoJulia.spring.MySchedule.repository.TaskRepository;
import by.PetrenkoJulia.spring.MySchedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> TasksShow(){
        return taskRepository.findAll();
    }

//    public List<Task> tasksShowForUser(int user_id){
//        return taskRepository.findByUser_id(user_id);
//    }
    public void CreateTask(String name){
        Task task = new Task(name);
    }


}
