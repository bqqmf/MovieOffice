package com.example.movieoffice.discount;

import com.example.movieoffice.customer.Customer;
import com.example.movieoffice.customer.Grade;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
@Primary
public class FixDiscountPolicy implements DiscountPolicy {
   private static final int fixDiscountAmount = 1000;
    @Override
    public int discount(Customer customer, int moviePrice) {
        return switch (customer.getGrade()) {
            case VIP -> moviePrice - 2 * fixDiscountAmount;
            case GOLD -> moviePrice - fixDiscountAmount;
            default -> 0;
        };
    }
}
