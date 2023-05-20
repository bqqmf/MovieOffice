package com.example.movieoffice.ticketoffice;

import com.example.movieoffice.Config;
import com.example.movieoffice.movie.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TicketOfficeImplTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
    TicketOffice ticketOffice;

    @BeforeEach
    void beforeEach() {
        ticketOffice = ac.getBean(TicketOffice.class);
        MovieRepository movieRepository = ac.getBean(MovieRepository.class);

    }

    @Test
    void bookFromCGV() {
//        Movie avatar = ticketOffice.book("CGV", "아바타");
//        Assertions.assertThat(avatar).isInstanceOf(Movie.class);
        ticketOffice.printMovies("cgv");
    }
}