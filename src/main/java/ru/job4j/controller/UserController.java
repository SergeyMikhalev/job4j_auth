package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.job4j.domain.Person;
import ru.job4j.service.PersonService;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final PersonService users;
    private final BCryptPasswordEncoder encoder;


    @PostMapping("/sign-up")
    public void signUp(@RequestBody Person person) {
        if (Objects.isNull(person.getPassword())) {
            throw new NullPointerException("from user controller");
        }
        person.setPassword(encoder.encode(person.getPassword()));
        users.save(person);
    }

    @GetMapping("/all")
    public List<Person> findAll() {
        return users.findAll();
    }
}
