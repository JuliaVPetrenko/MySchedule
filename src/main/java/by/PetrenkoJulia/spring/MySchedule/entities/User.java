package by.PetrenkoJulia.spring.MySchedule.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "users")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(unique = true, nullable = false)
 private String username;

 private String password;

 @ManyToMany
 @JoinTable(name = "users_roles",
         joinColumns = @JoinColumn(name = "user_id"),
         inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

// @ManyToMany
// @JoinTable(name = "users_tasks",
//         joinColumns = @JoinColumn(name = "user_id"),
//         inverseJoinColumns = @JoinColumn(name = "task_id"))
// private Collection<Task> tasks;
//
// public Collection<Task> getTasks() {
//  return tasks;
// }

}
