package com.example.movieoffice.customer;

public class Customer {
    String name;
    Long id;
    Grade grade;

    public Customer(String name, Long id, Grade grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
}
