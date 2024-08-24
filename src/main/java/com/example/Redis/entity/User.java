package com.example.Redis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable { // using serializable as this redis would not be able to understand our java code
    private Long id;
    private int age;
    private String firstName;
    private String lastName;
    private String emailId;
}
