package com.tcs.richard.CrudService.service;

import com.tcs.richard.CrudService.model.Person;
import com.tcs.richard.CrudService.repository.PersonRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Async
    public CompletableFuture<List<Person>> getAll() {
        return CompletableFuture.completedFuture(personRepository.findAll());
    }

    @Async
    public CompletableFuture<Person> saveOrUpdate(Person person) {
        return CompletableFuture.completedFuture(personRepository.save(person));
    }

    public void delete(String id) {
        personRepository.deleteById(id);
    }

}
