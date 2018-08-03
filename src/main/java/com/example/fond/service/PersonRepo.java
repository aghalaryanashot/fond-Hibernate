package com.example.fond.service;

import com.example.fond.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface PersonRepo extends CrudRepository<Person,Long> {
    List<Person> findBylastName(String lastname);
    @Query("select u from Person u where x.dateOfBirth between 1? and ?2")
    Person findByStartDateBetween(Date startDate, Date between);
}
