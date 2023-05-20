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
//    private final Map<TheaterType, Theater> theaterMap;
private final Map<String, Theater> theaterMap;

    @Override
    public Movie book(String theaterName, String title) {
        return this.theaterMap
                .get(theaterName)
                .book(title);
    }

    @Override
    public void printMovies(String theaterName) {
        Theater theater = theaterMap.entrySet().stream()
                .filter(entry -> entry.getValue().getType().name().equalsIgnoreCase(theaterName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(theaterName + "영화관이 존재하지 않습니다."))
                .getValue();
        theater.printMovies();
    }

    @Override
    public void printTheaters() {
        for (Map.Entry<String, Theater> entry : theaterMap.entrySet()) {
            System.out.println("entry.getKey() = " + entry.getKey());
            System.out.println("entry.getValue() = " + entry.getValue());
        }
    }
}