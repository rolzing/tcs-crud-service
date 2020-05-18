package com.tcs.richard.CrudService.repository;

import com.tcs.richard.CrudService.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

}
