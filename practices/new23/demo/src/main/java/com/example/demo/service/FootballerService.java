package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Footballer;
import com.example.demo.repositories.FootballerRepository;

@Service
public class FootballerService {
    @Autowired
    private FootballerRepository footballerRepository;
    

    public Footballer save(Footballer footballer){
        return footballerRepository.save(footballer);
    }

    public void deleteById(Long id){
        footballerRepository.deleteById(id);
    }

    public List<Footballer> findAll(){
        return footballerRepository.findAll();
    }

    public List<Footballer> getSorted(){
        return footballerRepository.findAll(Sort.by("firstName"));
    }

    public List<Footballer> filterByName(String name){
        return footballerRepository.findByName(name);
    }
}
