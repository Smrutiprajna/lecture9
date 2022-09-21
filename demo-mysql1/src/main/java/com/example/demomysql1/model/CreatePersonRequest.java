package com.example.demomysql1.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CreatePersonRequest {
    @NotBlank(message = "Firstname cant be empty")
    private String firstname;
    private String lastname;
    @NotBlank(message = "DOB Cant be empty")
    private String dob;

    public Person to()
    {
        return Person.builder().firstname(firstname).lastname(lastname).dob(dob).build();
    }
}
