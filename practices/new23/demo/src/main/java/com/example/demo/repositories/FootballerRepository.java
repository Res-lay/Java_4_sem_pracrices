package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Footballer;


@Repository
public interface FootballerRepository extends JpaRepository<Footballer, Long>{
    public List<Footballer> findByName(String name);
}
