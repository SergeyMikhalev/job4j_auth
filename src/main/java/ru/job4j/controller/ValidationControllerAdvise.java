package ru.job4j.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationControllerAdvise {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handle(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(
                e.getConstraintViolations()
                        .stream()
                        .map(f -> f.getMessageTemplate() + " Invalid value = " + f.getInvalidValue())
                        .collect(Collectors.toList())
        );
    }

}
