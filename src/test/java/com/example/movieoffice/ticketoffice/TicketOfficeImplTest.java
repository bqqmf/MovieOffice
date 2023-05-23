package com.example.movieoffice.ticketoffice;

import com.example.movieoffice.Config;
import com.example.movieoffice.movie.Movie;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TicketOfficeImplTest {
    TicketOffice ticketOffice;

    @BeforeEach
    void setUp() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        ticketOffice = ac.getBean(TicketOffice.class);
    }

    @Test
    void book() {
        // given
        String theaterName = "cgv";
        Long id = 100L;
        String title = "아바타";
        String genre = "SF";
        int runningTime = 180;

        // when
        Movie bookedMovie = ticketOffice.book(theaterName, id, title);

        // then
        Assertions.assertThat(bookedMovie).isNotNull();
        Assertions.assertThat(bookedMovie.getTitle()).isEqualTo(title);
        Assertions.assertThat(bookedMovie.getGenre()).isEqualTo(genre);
        Assertions.assertThat(bookedMovie.getRunningTime()).isEqualTo(runningTime);
    }
}