package com.example.movieoffice.customer;

public interface CustomerRepository {
    void save(Customer customer);

    Customer retrieve(Long id);
}
