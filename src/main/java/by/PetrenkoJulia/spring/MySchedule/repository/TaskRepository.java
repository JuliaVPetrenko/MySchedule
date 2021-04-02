package by.PetrenkoJulia.spring.MySchedule.repository;

import by.PetrenkoJulia.spring.MySchedule.entities.Task;
import by.PetrenkoJulia.spring.MySchedule.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

//    Task findByName(String name);
//    List<Task> findByUser_id(Integer id);
    List<Task> findByUsersIsContaining(User user);
}
