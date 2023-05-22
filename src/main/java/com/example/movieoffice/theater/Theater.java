package com.example.movieoffice.theater;

import com.example.movieoffice.customer.Customer;
import com.example.movieoffice.movie.Movie;

import java.util.List;

public interface Theater {
    static final TheaterType type = null;

    Movie book(Long id, String title); // id가 제목으로 영화 예매
    void printMovies(); // 상영중인 영화 목록 출력
    TheaterType getType(); // 영화관 종류 반환

    void join(Customer customer); // 회원 가입
    Customer findCustomer(Long customerId); // 회원 검색
    List<Movie> getMovies(); // 상영 영화 목록 가져오기
    void registerMovie(Movie movie); // 영화 추가

    Movie findMovie(String title); // 영화 검색

    int getDiscountPrice(Customer customer, int price); // 회원 별 할인 가격

    enum TheaterType {
        CGV, MEGA, LOTTE
    }
}
