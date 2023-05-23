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
        assertThat(target.getTitle()).isEqualTo(movie.getTitle());
        assertThat(target.getGenre()).isEqualTo(movie.getGenre());
        assertThat(target.getRunningTime()).isEqualTo(movie.getRunningTime());
    }

    @Test
    void bookFailNoCustomer() {
        // given
        Customer nonExistCustomer = new Customer("김삿갓", 150L, Grade.VIP);
        String title = "아바타";
        Movie movie = new Movie(title, "SF", 180);

        // when
        theater.registerMovie(movie);
        theater.registerMovie(new Movie(title, "SF", 1801));

        // then
        assertThrows(IllegalArgumentException.class, () -> theater.book(nonExistCustomer.getId(), title));
    }

    @Test
    void bookFailNoMovie() {
        // given
        Customer customer = new Customer("홍길동", 100L, Grade.VIP);
        String title = "슈퍼배드";

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
        assertThat(movies.size()).isEqualTo(4); // 추가 이전에 1개 영화가 있어서 4
    }
}