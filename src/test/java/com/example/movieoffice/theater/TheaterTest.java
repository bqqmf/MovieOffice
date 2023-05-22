package com.example.movieoffice.theater;

import com.example.movieoffice.Config;
import com.example.movieoffice.customer.Customer;
import com.example.movieoffice.customer.Grade;
import com.example.movieoffice.movie.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TheaterTest {
    Theater theater;

    @BeforeEach
    void setUp() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        theater = ac.getBean(Cgv.class);

    }

    @Test
    void bookSuccess() {
        // given
        Customer customer = new Customer("홍길동", 100L, Grade.VIP);
        String title = "아바타";
        Movie movie = new Movie(title, "SF", 180);

        // when
        theater.join(customer);
        theater.registerMovie(movie);
        Movie target = theater.book(customer.getId(), title);

        // then
        assertThat(target).isNotNull();
        assertThat(target).isEqualTo(movie);
    }

    @Test
    void bookFailNoCustomer() {
        // given
        Customer customer = new Customer("홍길동", 100L, Grade.VIP);
        String title = "아바타";
        Movie movie = new Movie(title, "SF", 180);

        // when
        theater.registerMovie(movie);

        // then
        assertThrows(IllegalArgumentException.class, () -> theater.book(customer.getId(), title));
    }

    @Test
    void bookFailNoMovie() {
        // given
        Customer customer = new Customer("홍길동", 100L, Grade.VIP);
        String title = "아바타";
        Movie movie = new Movie(title, "SF", 180);

        // when
        theater.join(customer);

        // then
        assertThrows(IllegalArgumentException.class, () -> theater.book(customer.getId(), title));

    }

    @Test
    void getMovies() {
        // given
        Movie movie1 = new Movie("아바타", "SF", 180);
        Movie movie2 = new Movie("아바타", "SF", 180);
        Movie movie3 = new Movie("아바타", "SF", 180);

        // when
        theater.registerMovie(movie1);
        theater.registerMovie(movie2);
        theater.registerMovie(movie3);
        List<Movie> movies = theater.getMovies();

        // then
        assertThat(movies).isInstanceOf(List.class);
        assertThat(movies.size()).isEqualTo(3);
    }

    @Test
    void registerMovie() {
        // given
        String title = "아바타";
        Movie movie1 = new Movie(title, "SF", 180);

        // when
        theater.registerMovie(movie1);
        Movie target = theater.findMovie(title);

        // then
        assertThat(target).isNotNull();

        int movieNum = theater.getMovies().size();
        assertThat(movieNum).isEqualTo(1);
    }

    @Test
    void findMovieSuccess() {
        // given
        String title = "아바타";
        Movie movie1 = new Movie(title, "SF", 180);

        // when
        theater.registerMovie(movie1);
        Movie target = theater.findMovie(title);

        // then
        assertThat(target).isNotNull();

        int movieNum = theater.getMovies().size();
        assertThat(movieNum).isEqualTo(1);
    }

    @Test
    void findMovieFail() {
        // given
        String title = "아바타";
        Movie movie1 = new Movie(title, "SF", 180);

        // when
        theater.registerMovie(movie1);
        String nonExistTitle = "슈퍼배드";

        // then
        assertThrows(IllegalArgumentException.class, () -> theater.findMovie(nonExistTitle));
    }

    @Test
    void joinSuccess() {
        // given
        Customer customer = new Customer("홍길동", 100L, Grade.VIP);

        // when
        theater.join(customer);
        Customer target = theater.findCustomer(100L);

        // then
        assertThat(target.getId()).isEqualTo(100L);
        assertThat(target.getName()).isEqualTo("홍길동");
        assertThat(target.getGrade()).isEqualTo(Grade.VIP);
    }

    @Test
    void findCustomerSuccess() {
        // given
        Customer customer = new Customer("홍길동", 100L, Grade.VIP);

        // when
        theater.join(customer);
        Customer target = theater.findCustomer(100L);

        // then
        assertThat(target.getId()).isEqualTo(100L);
        assertThat(target.getName()).isEqualTo("홍길동");
        assertThat(target.getGrade()).isEqualTo(Grade.VIP);
    }

    @Test
    void findCustomerFail() {
        // given
        Customer customer = new Customer("홍길동", 100L, Grade.VIP);

        // when
        theater.join(customer);
        Long wrongId = 200L;

        // then
        assertThrows(IllegalArgumentException.class, () -> theater.findCustomer(wrongId));
    }

    @Test
    void getDiscountPrice() {
        // given
        Customer customer = new Customer("홍길동", 100L, Grade.VIP);

        // when
        theater.join(customer);
        int discountedPrice = theater.getDiscountPrice(customer, 12000);

        // then
        assertThat(discountedPrice).isEqualTo(10000);
    }
}