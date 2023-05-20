package com.example.movieoffice.theater;

import com.example.movieoffice.movie.Movie;

public interface Theater {
    Movie book(String title); // 제목으로 영화 예매
    void printMovies(); // 상영중인 영화 목록 출력

    TheaterType getType();
}
