package com.moto.spring_demo.controller.api.v1;

import com.moto.spring_demo.domain.Task;
import com.moto.spring_demo.repository.TaskRepository;
import com.moto.spring_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by nahid on 11/6/17.
 */

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/{userId}/newtask")
    public ResponseEntity<Task> createTask(
            @RequestBody Map<String, String> payload,
            @PathVariable("userId") Long userId ) {

        Task task = new Task();
        task.setName(payload.get("name"));
        task.setPriority(payload.get("priority"));
        task.setStatus(payload.get("status"));
        task.setUser(userRepository.findOne(userId));
        taskRepository.save(task);

        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping("/task/all")
    public List<Task> getAllTask() {

        return taskRepository.findAll();
    }
}
