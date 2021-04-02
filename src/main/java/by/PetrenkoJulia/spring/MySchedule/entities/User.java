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
 private Integer id;

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

 public User() {
 }

 public User(String username) {
  this.username = username;
 }

// public void setTasks(Collection<Task> tasks) {
//  this.tasks = tasks;
// }

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public String getUsername() {
  return username;
 }

 public void setUsername(String username) {
  this.username = username;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public Collection<Role> getRoles() {
  return roles;
 }

 public void setRoles(Collection<Role> roles) {
  this.roles = roles;
 }

}
