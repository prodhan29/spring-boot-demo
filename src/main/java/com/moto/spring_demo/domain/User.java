package com.moto.spring_demo.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name ="user")
public class User extends BaseEntity {

    @Size(max = 32)
    private String name;

    @Size(max = 32, message = "username is too long")
    @Column(unique = true)
    private String username;

    @OneToMany
    private List<Task>tasks ;

    @ManyToOne
    private Company company;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username +
                '}';
    }
}
