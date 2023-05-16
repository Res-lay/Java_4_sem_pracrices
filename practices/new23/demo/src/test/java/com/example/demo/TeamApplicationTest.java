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

import com.example.demo.model.Team;
import com.example.demo.repositories.TeamRepository;
import com.example.demo.service.TeamService;

@ExtendWith(MockitoExtension.class)
public class TeamApplicationTest {
    @Mock
    private TeamService teamService;
    @Mock
    private TeamRepository teamRepository;

    @Captor
    ArgumentCaptor<Team> captor;


  

   

    @Test
    void getTeams(){
        Team team1 = new Team("Eagles", "11.01.2001");
        Team team2 = new Team("Richmond", "14.10.1988");

        Mockito.when(teamService.findAll()).thenReturn(List.of(team1, team2));
        Assertions.assertEquals(2, teamService.findAll().size());
        Assertions.assertEquals("Richmond", teamService.findAll().get(1).getName());
    }
    
}
