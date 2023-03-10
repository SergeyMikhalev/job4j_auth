package ru.job4j.dto;

import lombok.Data;
import javax.validation.constraints.Size;

@Data
public class PersonLoginUpdate {
    private int id;

    @Size(min = 3, max = 50, message = "login size must be between 3 and 50")
    private String newLogin;

    @Size(min = 3, max = 50, message = "login size must be between 3 and 50")
    private String confirmedLogin;
}
