package com.moto.spring_demo.service.security;

import com.moto.spring_demo.domain.User;
import com.moto.spring_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        System.out.println("------------user info-------------");
        System.out.println(user.toString());
        System.out.println("username: "+ username);
        if (user == null) throw new UsernameNotFoundException("No user found with this email " + username);
        return user;
    }
}
