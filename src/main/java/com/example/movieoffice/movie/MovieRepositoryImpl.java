package com.example.movieoffice.movie;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieRepositoryImpl implements MovieRepository{
    private final List<Movie> movies = new ArrayList<>();
    @Override
    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public void save(Movie movie) {
        movies.add(movie);
    }

    @Override
    public Movie retrieve(String title) {
        return this.movies.stream()
                .filter(movie -> movie.title.equals(title))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(title + "영화는 없습니다."));
    }
}
