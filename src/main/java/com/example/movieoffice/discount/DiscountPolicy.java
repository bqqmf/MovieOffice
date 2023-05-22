package com.example.movieoffice.discount;

import com.example.movieoffice.customer.Customer;

public interface DiscountPolicy {
    int discount(Customer customer, int moviePrice);
}
