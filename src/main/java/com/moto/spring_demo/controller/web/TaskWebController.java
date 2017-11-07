package com.moto.spring_demo.controller.web;

import com.moto.spring_demo.domain.Task;
import com.moto.spring_demo.repository.TaskRepository;
import com.moto.spring_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by nahid on 11/7/17.
 */
@Controller
public class TaskWebController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/task/index")
    public String getAllTask(Model model){

        model.addAttribute("allTask", taskRepository.findAll());
        return "task/index";
    }

    @GetMapping("/task/create")
    public String createTask(Model model) {

        model.addAttribute("task", new Task());
        model.addAttribute("allUsers", userRepository.findAll());
        return"task/create";
    }

    @PostMapping("/task/save")
    public String saveTask(@ModelAttribute Task task){

        taskRepository.save(task);
        return "redirect:/";
    }
}
