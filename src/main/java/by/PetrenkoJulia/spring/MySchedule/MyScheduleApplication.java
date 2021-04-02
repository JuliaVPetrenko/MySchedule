package by.PetrenkoJulia.spring.MySchedule;

import by.PetrenkoJulia.spring.MySchedule.entities.Task;
import by.PetrenkoJulia.spring.MySchedule.repository.TaskRepository;
import by.PetrenkoJulia.spring.MySchedule.services.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class MyScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyScheduleApplication.class, args);
//		ConfigurableApplicationContext context = SpringApplication.run(MyScheduleApplication.class, args);
//		TaskRepository taskRepository = context.getBean(TaskRepository.class);
//
//		taskRepository.save(new Task("Task11"));
//		taskRepository.save(new Task("Task2"));
//		taskRepository.save(new Task("Task3"));
//		taskRepository.save(new Task("Task4"));
//
//		Iterable<Task> tasks = taskRepository.findAll();

//

//		TaskService taskService = context.getBean(TaskService.class);
//
//		taskService.saveTask(new Task("Task8"));
//
//		Iterable<Task> tasks = taskService.TasksShow();
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//
//		tasks.forEach(t -> System.out.println(t.getName()));

	}

}
