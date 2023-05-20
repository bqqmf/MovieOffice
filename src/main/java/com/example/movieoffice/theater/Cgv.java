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
    private final TheaterType type = TheaterType.CGV; // 영화관 종류
    private final int moviePrice = 10000; // 영화 가격


    @Override
    public Movie book(String title) {
        return movieRepository.retrieve(title);
    }

    @Override
    public void printMovies() {
        List<Movie> movies = movieRepository.getMovies();
        for (Movie movie : movies) {
            System.out.println("movie = " + movie);
        }
    }

    @Override
    public TheaterType getType() {
        return this.type;
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.getMovies();
    }

    @Override
    public void registerMovie(Movie movie) {
        this.movieRepository.save(movie);
    }

    @Override
    public Movie findMovie(String title) {
        return this.movieRepository.retrieve(title);
    }
}
