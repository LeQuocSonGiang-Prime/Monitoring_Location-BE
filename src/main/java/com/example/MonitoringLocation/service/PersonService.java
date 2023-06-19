package com.example.MonitoringLocation.service;

import com.example.MonitoringLocation.model.Person;
import com.example.MonitoringLocation.model.User;

import java.util.List;

public interface PersonService {

    List<Person> getAllByUser(Long user_id);

    String insert(Person person);


    Person checkPersonByToken(String token);

    int deletePerson(Long id);
}
