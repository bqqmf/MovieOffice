package com.example.movieoffice.movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getMovies(); // 상영 영화 목록 가져오기
    void save(Movie movie); // 영화 추가

    Movie retrieve(String title); // 제목으로 영화 검색
}
