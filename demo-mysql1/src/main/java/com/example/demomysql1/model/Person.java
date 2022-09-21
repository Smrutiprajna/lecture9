package com.example.demomysql1.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Person {
    private Integer id;
    private String firstname;
    private String lastname;
    private String dob;
    private Integer age;

}
