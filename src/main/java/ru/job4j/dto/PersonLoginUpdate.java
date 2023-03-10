package ru.job4j.dto;

import lombok.Data;

@Data
public class PersonLoginUpdate {
    private int id;
    private String newLogin;
    private String confirmedLogin;
}
