package com.subh.jpademo.controller;

import com.subh.jpademo.entity.Animal;
import com.subh.jpademo.repository.AnimalRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnimalController {

    @Autowired
    private AnimalRepo animalRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/animal")
    public Animal saveAnimal(@RequestBody Animal animal) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Animal animalDb = animalRepo.save(animal);

        animalDb.setCount(99);

        entityManager.detach(animalDb);
        entityManager.merge(animalDb);
        animalRepo.flush();

        return animalDb;

    }

    @GetMapping("/cache/animal/{id}")
    public Animal saveAnimal1(@PathVariable int id) {

        Animal animalDb = animalRepo.findById(id).get();

        Animal animalDb1 = animalRepo.findById(id).get();


        return animalDb;

    }



}
