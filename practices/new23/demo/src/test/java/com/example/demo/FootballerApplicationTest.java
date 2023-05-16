package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Footballer;
import com.example.demo.repositories.FootballerRepository;
import com.example.demo.service.FootballerService;


@ExtendWith(MockitoExtension.class)
public class FootballerApplicationTest {
    @Mock
    private FootballerService footballerService;
    @Mock
    private FootballerRepository footballerRepository;

    @Captor
    ArgumentCaptor<Footballer> captor;


  

   

    @Test
    void getTeams(){
        Footballer footballer1 = new Footballer("Billy", "Butcher");
        Footballer footballer2 = new Footballer("Killy", "Blcak");

        Mockito.when(footballerService.findAll()).thenReturn(List.of(footballer1, footballer2));
        Assertions.assertEquals(2, footballerService.findAll().size());
        Assertions.assertEquals("Killy", footballerService.findAll().get(1).getName());
    }
}
