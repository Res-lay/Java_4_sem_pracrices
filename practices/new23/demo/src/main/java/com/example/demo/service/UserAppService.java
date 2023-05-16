package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.UserApp;
import com.example.demo.repositories.UserRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class UserAppService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UserApp userApp = new UserApp(userRepository.findByUsername(username));
        if(userApp.getUser() == null){
            throw new UsernameNotFoundException("username " + username + " doesn't exist");
        }

        return userApp;
    }


    public String signUpUser(User user){
        boolean exist = userRepository.findByUsername(user.getUsername()) != null;
        if (exist){
            throw new IllegalAccessError("already exist");
        }
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return "login";
    }
    public List<User> getUser(){
        return userRepository.findAll();
    }
}
