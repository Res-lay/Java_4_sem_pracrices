package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "team")
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATIONDATE")
    private String creationDate;

    @SequenceGenerator(name = "team_seq", sequenceName =
            "team_sequence", allocationSize = 1)
    @GeneratedValue(generator = "team_seq", strategy =
            GenerationType.SEQUENCE)
    
    @OneToMany(mappedBy = "team")
    public List<Footballer> footballers;

    public Team(String name, String creationDate){
        this.creationDate = creationDate;
        this.name = name;
    }
}
