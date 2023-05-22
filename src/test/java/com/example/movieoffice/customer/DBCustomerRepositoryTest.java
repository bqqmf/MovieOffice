package com.example.movieoffice.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DBCustomerRepositoryTest {
    @Autowired
    DBCustomerRepository dbRepository;

    @BeforeEach
    void beforeEach() {
        Customer customer = new Customer("홍길동", 100L, Grade.BASIC);
        dbRepository.save(customer);
    }

    @Test
    void save() {
        Customer customer = new Customer("짱구", 200L, Grade.BASIC);

        dbRepository.save(customer);

        Customer result = dbRepository.retrieve(200L);
        assertThat(result).isNotNull();
    }

    @Test
    void retrieve() {
        Customer result = dbRepository.retrieve(100L);
        assertThat(result).isNotNull();
    }
}