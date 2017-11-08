package com.moto.spring_demo.controller.web;

import com.moto.spring_demo.domain.User;
import com.moto.spring_demo.repository.TaskRepository;
import com.moto.spring_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by nahid on 11/7/17.
 */

@Controller
public class UserWebController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("")
    public String index(Model model){

        model.addAttribute("allUsers", userRepository.findAll());
        model.addAttribute("pass", new BCryptPasswordEncoder().encode("nahid"));
        return "user/index";
    }

    @GetMapping("/user/{userId}/info")
    public String userInfo(@PathVariable("userId") Long userId, Model model){

        User user = userRepository.findOne(userId);
        model.addAttribute("user", user);
        model.addAttribute("tasks", taskRepository.findTasksByUser(user));
        System.out.println("----------------------------------");
//        System.out.println(user.getTasks().size());
        return "user/info";
    }

    @GetMapping("/user/{userId}/edit")
    public String userEdit(@PathVariable("userId") Long userId, Model model){

        model.addAttribute("user", userRepository.findOne(userId));
        return "user/edit";
    }

    @PostMapping("/user/update")
    public String userUpdate(@ModelAttribute User user, Model model){

        String endcodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(endcodedPassword);
        userRepository.save(user);
        return "redirect:/";
    }

    // @DeleteMapping can only be used in Api
    @GetMapping("/user/{userId}/delete")
    public String userDelete(@PathVariable("userId") Long Id, Model model) {

        userRepository.delete(Id);
        return "redirect:/";
    }
}
