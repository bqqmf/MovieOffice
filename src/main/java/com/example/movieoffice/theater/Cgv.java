package com.example.movieoffice.theater;

import com.example.movieoffice.movie.Movie;
import com.example.movieoffice.movie.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Cgv implements Theater {
    private final MovieRepository movieRepository; // 영화들을 가지는 객체
    private final int price = 10000; // 영화 가격

    private final TheaterType type = TheaterType.CGV; // 영화관 종류

    @Override
    public Movie book(String title) {
        return movieRepository.getMovie(title);
    }

    @Override
    public void printMovies() {
        List<Movie> movies = movieRepository.getMovies();
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    @Override
    public TheaterType getType() {
        return this.type;
    }

}
