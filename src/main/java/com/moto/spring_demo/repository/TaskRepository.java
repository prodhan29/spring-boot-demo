package com.moto.spring_demo.repository;

import com.moto.spring_demo.domain.Task;
import com.moto.spring_demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by nahid on 11/6/17.
 */
public interface TaskRepository extends JpaRepository<Task, Long>{

    List<Task> findTasksByUser(User user);
}
