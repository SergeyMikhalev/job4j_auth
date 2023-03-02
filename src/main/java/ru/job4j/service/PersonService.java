package ru.job4j.service;

import ru.job4j.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findAll();

    Person save(Person person);

    Optional<Person> findById(Integer id);

    void delete(Person person);

    boolean existsById(Integer id);
}
