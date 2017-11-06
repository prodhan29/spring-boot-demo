package com.moto.spring_demo.controller.api.v1;

import com.moto.spring_demo.domain.User;
import com.moto.spring_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String home(){

        return "hello  world";
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> payload) {

        System.out.println(payload.get("name"));
        System.out.println(payload.get("username"));
        User user = new User();
        user.setName(payload.get("name"));
        user.setUsername(payload.get("username"));

        userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/user/find/{username}")
    public ResponseEntity<User> findUser(@PathVariable("username") String username) {

//        User user = userRepository.findByUsername(username);
        User user =userRepository.findByUsernameContaining(username);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
