package com.example.fond.service;

import com.example.fond.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepo extends CrudRepository<Person,Long> {
    List<Person> findBylastName(String lastname);
}
