package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.domain.Person;
import ru.job4j.repository.PersonRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    public static final String FORBIDDEN_LOGIN = "ZXC180";
    private final PersonRepository repository;

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Person save(Person person) {
        if (FORBIDDEN_LOGIN.equals(person.getLogin())) {
            throw new IllegalArgumentException("Запрещенный логин!");
        }
        return repository.save(person);
    }

    @Override
    public Person findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Не удалось найти персону с id =" + id)
                );
    }

    @Override
    public void delete(Person person) {
        repository.delete(person);
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }
}
