package com.subh.jpademo.service;

import com.subh.jpademo.entity.Animal;
import com.subh.jpademo.exception.MyException;
import com.subh.jpademo.repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepo animalRepo;



    @Async(value = "executorService")
    public ResponseEntity<Object> saveAnimals(List<Animal> animals) {


        System.out.println("Thread Name : "+Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<Animal> animalList = animalRepo.saveAll(animals);

        return  new ResponseEntity<>(animalList, HttpStatus.OK);
    }


    @Retryable(
            value = {MyException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 3000)
    )
    public ResponseEntity<Object> saveAnimal(Animal animal) {

        if(animal.getName().equals("exception"))
            throw new MyException("DB not accesable");
        Animal animal1 = animalRepo.save(animal);
        return  new ResponseEntity<>(animal1, HttpStatus.OK);
    }
    @Recover()
    public ResponseEntity<Object> recoverMethod(MyException exception, List<Animal> animals) {
        return  new ResponseEntity<>("DataBase is down. Try after 5 minute.", HttpStatus.REQUEST_TIMEOUT);
    }
}
