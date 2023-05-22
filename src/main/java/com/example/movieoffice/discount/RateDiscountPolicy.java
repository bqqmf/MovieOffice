package com.example.movieoffice.discount;

import com.example.movieoffice.customer.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class RateDiscountPolicy implements DiscountPolicy {
   private static final int  rateDiscountRatio = 20;
    @Override
    public int discount(Customer customer, int price) {
        return switch (customer.getGrade()) {
            case VIP -> price * 2 * rateDiscountRatio / 100;
            case GOLD -> price * rateDiscountRatio / 100;
            default -> 0;
        };
    }
}
