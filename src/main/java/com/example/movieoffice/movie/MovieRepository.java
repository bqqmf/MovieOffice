package com.example.movieoffice.movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getMovies(); // 상영 영화 목록 가져오기
    void registerMovie(Movie movie); // 영화 추가

    Movie getMovie(String title); // 제목으로 영화 검색
}
