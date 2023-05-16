package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Team;
import com.example.demo.service.TeamService;


@RestController
@RequestMapping("/team")
public class teamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getFootballers(){
        return teamService.findAll();
    }

    @GetMapping("/Name")
    public List<Team> filterByName(){
        return teamService.getSorted();
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id){
        teamService.deleteById(id);
    }

    @PostMapping
    public void saveTeam(@RequestBody Team team){
        teamService.save(team);
    }
}
