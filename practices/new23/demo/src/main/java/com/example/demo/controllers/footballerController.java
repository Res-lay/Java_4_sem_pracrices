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

import com.example.demo.model.Footballer;
import com.example.demo.service.FootballerService;

@RestController
@RequestMapping("/footballer")
public class footballerController {
    @Autowired
    private FootballerService footballerService;

    @GetMapping
    public List<Footballer> getFootballers(){
        return footballerService.findAll();
    }

    @GetMapping("/{name}")
    public List<Footballer> filterByName(@PathVariable("name") String name){
        return footballerService.filterByName(name);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id){
        footballerService.deleteById(id);
    }

    @PostMapping
    public void saveFootballer(@RequestBody Footballer footballer){
        footballerService.save(footballer);
    }
}
