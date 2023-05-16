package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Team;
import com.example.demo.repositories.TeamRepository;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public void deleteById(Long id){
        teamRepository.deleteById(id);
    }

    public List<Team> findByName(String name){
        return teamRepository.findByName(name);
    }

    public void save(Team team){
        teamRepository.save(team);
    }

    public List<Team> getSorted(){
        return teamRepository.findAll(Sort.by("name"));
    }

     public List<Team> findAll(){
        return teamRepository.findAll();
    }
}
