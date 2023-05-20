package com.example.movieoffice.ticketoffice;

import com.example.movieoffice.movie.Movie;
import com.example.movieoffice.movie.MovieRepositoryImpl;
import com.example.movieoffice.theater.Cgv;
import com.example.movieoffice.theater.Theater;
import com.example.movieoffice.theater.TheaterType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class TicketOfficeImplTest {

    TicketOfficeImpl ticketOffice;

    @BeforeEach
    void beforeEach() {
        HashMap<TheaterType, Theater> map = new HashMap<>();
        MovieRepositoryImpl movieRepository = new MovieRepositoryImpl();
        movieRepository.registerMovie(new Movie("아바타", "SF", 180));
        map.put(TheaterType.CGV, new Cgv(movieRepository));

        ticketOffice = new TicketOfficeImpl(map);
    }

    @Test
    void bookFromCGV() {
        Movie avatar = ticketOffice.book(TheaterType.CGV, "아바타");
        Assertions.assertThat(avatar).isInstanceOf(Movie.class);
    }
}