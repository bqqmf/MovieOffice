package com.example.movieoffice.movie;

import com.example.movieoffice.Config;
import com.sun.nio.sctp.IllegalUnbindException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryImplTest {
    MovieRepository movieRepository;

    @BeforeEach
    void setUp() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        movieRepository = ac.getBean(MovieRepository.class);
        movieRepository.save(new Movie("아바타", "SF", 180));
        movieRepository.save(new Movie("범죄도시3", "스릴러", 120));
        movieRepository.save(new Movie("가오갤3", "SF", 150));
    }

    @Test
    void getMovies() {
        List<Movie> movies = movieRepository.getMovies();
        assertThat(movies).isInstanceOf(List.class);
        assertThat(movies.size()).isEqualTo(3);
    }

    @Test
    void save() {
        // given
        Movie movie = new Movie("분노의질주", "스릴러", 120);

        // when
        movieRepository.save(movie);
        List<Movie> movies = movieRepository.getMovies();

        // then
        assertThat(movies.size()).isEqualTo(4);
    }

    @Test
    void retrieve() {
        Movie existMovie1 = movieRepository.retrieve("아바타");
        Movie existMovie2 = movieRepository.retrieve("범죄도시3");
        Movie existMovie3 = movieRepository.retrieve("가오갤3");

        assertThat(existMovie1).isNotNull();
        assertThat(existMovie2).isNotNull();
        assertThat(existMovie3).isNotNull();
        assertThrows(IllegalArgumentException.class, () -> movieRepository.retrieve("마리오카트"));
    }
}