package com.example.movieoffice.ticketoffice;

import com.example.movieoffice.movie.Movie;
import com.example.movieoffice.theater.Theater;
import com.example.movieoffice.theater.TheaterType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@RequiredArgsConstructor
public class TicketOfficeImpl implements TicketOffice {
    private final Map<TheaterType, Theater> theaterMap;

    @Override
    public Movie book(TheaterType type, String title) {
        return this.theaterMap
                .get(type)
                .book(title);
    }

    @Override
    public void printMovies(TheaterType type) {
        /*this.theaters.stream()
                .filter(theater -> type.equals(theater.getType()))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException(type + "영화관이 존재하지 않습니다."))
                .printMovies();*/
    }

    @Override
    public void printTheaters() {
        /*for (Theater theater : theaters) {
            System.out.println("theater = " + theater);
        }*/
    }
}