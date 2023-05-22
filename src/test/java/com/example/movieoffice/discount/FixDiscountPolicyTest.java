package com.example.movieoffice.discount;

import com.example.movieoffice.Config;
import com.example.movieoffice.customer.Customer;
import com.example.movieoffice.customer.Grade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FixDiscountPolicyTest {
    DiscountPolicy discountPolicy;

    @BeforeEach
    void setUp() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        discountPolicy = ac.getBean(DiscountPolicy.class);
    }

    @Test
    void discount_vip() {
        // given
        Customer customer = new Customer("사자", 100L, Grade.VIP);

        // when
        int discountedPrice = discountPolicy.discount(customer, 20000);

        // then
        assertThat(discountedPrice).isEqualTo(18000);
    }

    @Test
    void discount_gold() {
        // given
        Customer customer = new Customer("호랑이", 100L, Grade.GOLD);

        // when
        int discountedPrice = discountPolicy.discount(customer, 20000);

        // then
        assertThat(discountedPrice).isEqualTo(19000);
    }
    @Test
    void discount_basic() {
        // given
        Customer customer = new Customer("호랑이", 100L, Grade.BASIC);

        // when
        int discountedPrice = discountPolicy.discount(customer, 20000);

        // then
        assertThat(discountedPrice).isEqualTo(20000);
    }
}