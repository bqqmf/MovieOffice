package com.example.movieoffice.ticketoffice;

import com.example.movieoffice.movie.Movie;
import com.example.movieoffice.theater.TheaterType;

public interface TicketOffice {
//    void setTheater(TheaterType type); // 영화관 종류로 영화관 설정
    Movie book(TheaterType type, String title); // 영화관 종류와 영화 제목으로 예매
    void printMovies(TheaterType type); // 특정 영화관의 상영중인 영화 목록 출력
    void printTheaters(); // 영화관 목록 출력
}
