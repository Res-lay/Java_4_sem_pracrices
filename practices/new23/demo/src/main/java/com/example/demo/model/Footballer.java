package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="footballer")
@NoArgsConstructor
public class Footballer {
    @Column(name = "FIRSTNAME")
    private String name;
    @Column(name = "LASTNAME")
    private String lastname;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @JsonIgnore
    @ManyToOne
    private Team team;

    public Footballer(String firstname, String lastname){
        this.name = firstname;
        this.lastname = lastname;
    }

}
