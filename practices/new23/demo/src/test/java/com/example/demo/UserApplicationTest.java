package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.User;
import com.example.demo.model.UserApp;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserAppService;

@ExtendWith(MockitoExtension.class)
public class UserApplicationTest {

    @Mock
    private UserRepository userRepository;

    private UserAppService userAppService;

    @BeforeEach
    public void setUp(){
        userAppService = new UserAppService(new BCryptPasswordEncoder(10), userRepository);
    }

    @Captor
    ArgumentCaptor<User> captor;

    @Test
    void getUsers(){
        User user = new User();
        user.setUsername("NewUser");
        User user2 = new User();
        user2.setUsername("NewUser2");
        Mockito.when(userRepository.findAll()).thenReturn(List.of(user, user2));


        Assertions.assertEquals(2, userAppService.getUser().size());
        Assertions.assertEquals("NewUser2", userAppService.getUser().get(1).getUsername());
    }

    @Test
    void saveOrUpdate(){
        User user = new User();
        user.setUsername("NewUser");
        user.setPassword("password");

        userAppService.signUpUser(user);
        
        UserApp userApp = new UserApp(user);

        Mockito.when(userRepository.findByUsername(userApp.getUsername())).thenReturn(user);

        User expected = userRepository.findByUsername(userApp.getUsername());

        Assertions.assertEquals(expected,user);
    }
}
