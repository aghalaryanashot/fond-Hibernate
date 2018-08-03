package com.example.fond.service;

import com.example.fond.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface PersonRepo extends CrudRepository<Person,Long> {
    List<Person> findByLastNameOrFirstName(String lastname,String firstname);
    List<Person> findBydateOfBirthBetween(Date start, Date between);
}
