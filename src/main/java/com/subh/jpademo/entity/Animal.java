package com.subh.jpademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Animal {

    @Id
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "animal_sequence_generator")
    @SequenceGenerator(name = "animal_sequence_generator", allocationSize = 100)*/
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String name;
    private int count;
}
