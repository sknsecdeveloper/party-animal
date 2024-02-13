package com.subh.jpademo.controller;

import com.subh.jpademo.entity.Animal;
import com.subh.jpademo.repository.AnimalRepo;
import com.subh.jpademo.service.AnimalService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    private AnimalRepo animalRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AnimalService animalService;

    @PostMapping("/animal")
    public ResponseEntity<Object> saveAnimal(@RequestBody Animal animal) {

       /* EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();*/

        return animalService.saveAnimal(animal);

      /*  animalDb.setCount(99);

        entityManager.detach(animalDb);
        entityManager.merge(animalDb);
        animalRepo.flush();*/



    }

    @PostMapping("/animals")
    public String saveAnimals(@RequestBody List<Animal> animals) {

        List<Animal> animals1 = animals.subList(0,animals.size()/2);
        List<Animal> animals2 = animals.subList(animals.size()/2,animals.size());

        animalService.saveAnimals(animals1);
        animalService.saveAnimals(animals2);
        return "started saving animals async";
    }

    @GetMapping("/cache/animal/{id}")
    public Animal saveAnimal1(@PathVariable int id) {

        Animal animalDb = animalRepo.findById(id).get();

        Animal animalDb1 = animalRepo.findById(id).get();


        return animalDb;

    }



}
