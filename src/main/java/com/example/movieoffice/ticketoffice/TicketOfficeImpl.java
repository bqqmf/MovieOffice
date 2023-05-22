package com.example.movieoffice.ticketoffice;

import com.example.movieoffice.movie.Movie;
import com.example.movieoffice.theater.Theater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@RequiredArgsConstructor
public class TicketOfficeImpl implements TicketOffice {
private final Map<String, Theater> theaterMap;

    @Override
    public Movie book(String theaterName, Long id, String title) {
        return this.theaterMap
                .get(theaterName)
                .book(id, title);
    }

    @Override
    public void printMovies(String theaterName) {
        theaterMap.entrySet().stream()
                .filter(entry -> entry.getValue().getType().name().equalsIgnoreCase(theaterName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(theaterName + "영화관이 존재하지 않습니다."))
                .getValue()
                .printMovies();
    }

    @Override
    public void printTheaters() {
        for (Theater theater : theaterMap.values()) {
            System.out.println("theater = " + theater);
        }
    }
}