package by.PetrenkoJulia.spring.MySchedule.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer priority = 1;
    private Date date_create;
    private Date date_start;

//    @ManyToMany
//    @JoinTable(name = "users_tasks",
//            joinColumns = @JoinColumn(name = "task_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private Collection<User> users;
//
//    public Collection<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Collection<User> users) {
//        this.users = users;
//    }

    protected Task() {
    }

    public Task(String name) {
        this.name = name;
        this.date_create = new Date();
//        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getDate_create() {
        return date_create;
    }

    public Date getDate_start() {
        return date_start;
    }


//    public void setDate_create(Date date_create) {
//        this.date_create = date_create;
//    }

    @Override
    public String toString() {
        return String.format("Task [%d %s]", id, name);
    }
}
