package com.example.movieoffice.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Scope("prototype")
@Primary
@Component
public class MemoryCustomerRepository implements CustomerRepository {
    private final Map<Long, Customer> customerMap = new HashMap<>();

    {
        customerMap.put(100L, new Customer("홍길동", 100L, Grade.VIP));
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public Customer retrieve(Long id) {
        return customerMap.entrySet().stream().filter(entry -> entry.getKey().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(id + "와 일치하는 Customer 가 없습니다."))
                .getValue();
    }
}
