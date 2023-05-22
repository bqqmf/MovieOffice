package com.example.movieoffice.customer;

import lombok.Getter;

@Getter
public class Customer {
    private final String name;
    private final Long id;
    private final Grade grade;

    public Customer(String name, Long id, Grade grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
}
