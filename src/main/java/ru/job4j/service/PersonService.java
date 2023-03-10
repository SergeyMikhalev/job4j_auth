package ru.job4j.service;

import ru.job4j.domain.Person;
import ru.job4j.dto.PersonLoginUpdate;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person save(Person person);

    Person findById(Integer id);

    void delete(Person person);

    boolean existsById(Integer id);

    Person updateLogin(PersonLoginUpdate update);
}
