package com.example.movieoffice.ticketoffice;

import com.example.movieoffice.Config;
import com.example.movieoffice.movie.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TicketOfficeImplTest {

    TicketOffice ticketOffice;

    @BeforeEach
    void beforeEach() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        ticketOffice = ac.getBean(TicketOffice.class);



    }

    @Test
    void bookAvatarFromCGV() {
        ticketOffice.book("cgv", 200L, "아바타");
    }
}