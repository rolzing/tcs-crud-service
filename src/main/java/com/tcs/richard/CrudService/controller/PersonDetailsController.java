package com.tcs.richard.CrudService.controller;

import com.tcs.richard.CrudService.model.Person;
import com.tcs.richard.CrudService.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;


@RestController
public class PersonDetailsController {

    private PersonService personService;

    public PersonDetailsController(PersonService personService) {
        this.personService = personService;
    }


    private static Function<Throwable, ResponseEntity<? extends Person>> handleSaveOrUpdateFailure = throwable -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    private static Function<Throwable, ResponseEntity<? extends List<Person>>> handleGetFailure = throwable -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    @GetMapping(value="/person")
    public CompletableFuture<ResponseEntity> getAll(){
        return personService.getAll().<ResponseEntity>thenApply(ResponseEntity::ok).exceptionally(handleGetFailure);
    }


    @PostMapping("/person")
    public CompletableFuture<ResponseEntity> createUser(@RequestBody @Validated Person person) {
        return personService.saveOrUpdate(person).<ResponseEntity>thenApply(ResponseEntity::ok).exceptionally(handleSaveOrUpdateFailure);

    }

    @PutMapping("/person")
    public CompletableFuture<ResponseEntity> updateUser(@RequestBody @Validated Person person){
        return personService.saveOrUpdate(person).<ResponseEntity>thenApply(ResponseEntity::ok).exceptionally(handleSaveOrUpdateFailure);
    }

    @DeleteMapping("/person")
    public ResponseEntity deleteUser(@PathVariable String id){
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
