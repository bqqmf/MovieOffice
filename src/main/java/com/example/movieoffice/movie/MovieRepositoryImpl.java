package com.example.movieoffice.movie;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieRepositoryImpl implements MovieRepository{
    private final List<Movie> movies = new ArrayList<>();

    @Override
    public List<Movie> getMovies() {
        return this.movies;
    }

    @Override
    public void save(Movie movie) {
        this.movies.add(movie);
    }

    {
        movies.add(new Movie("아바타", "SF", 180));
    }

    @Override
    public Movie retrieve(String title) {
        Movie movie1 = this.movies.stream()
                .filter(movie -> movie.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(title + "영화는 없습니다."));

        return new Movie(movie1.getTitle(), movie1.getGenre(), movie1.getRunningTime());
    }
}
