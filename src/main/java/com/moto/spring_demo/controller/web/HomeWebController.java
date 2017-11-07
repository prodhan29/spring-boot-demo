package com.moto.spring_demo.controller.web;

import com.moto.spring_demo.domain.User;
import com.moto.spring_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nahid on 11/7/17.
 */

@Controller
public class HomeWebController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String index(Model model){

        model.addAttribute("allUsers", userRepository.findAll());
        return "user/index";
    }

    @GetMapping("/user/{userId}/info")
    public String userInfo(@PathVariable("userId") Long userId, Model model){

        model.addAttribute("user", userRepository.findOne(userId));
        return "user/info";
    }

    @GetMapping("/user/{userId}/edit")
    public String userEdit(@PathVariable("userId") Long userId, Model model){

        model.addAttribute("user", userRepository.findOne(userId));
        return "user/edit";
    }

    @PostMapping("/user/update")
    public String userUpdate(@ModelAttribute User user, Model model){

        userRepository.save(user);
        model.addAttribute("allUsers", userRepository.findAll());
        return "user/index";
    }

    // @DeleteMapping can only be used in Api
    @GetMapping("/user/{userId}/delete")
    public String userDelete(@PathVariable("userId") Long Id, Model model) {

        userRepository.delete(Id);
        model.addAttribute("allUsers", userRepository.findAll());
        return "user/index";
    }
}
