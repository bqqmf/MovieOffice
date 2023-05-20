package com.example.movieoffice.movie;

public class Movie {
    String title; // 영화 제목
    String genre; // 영화 장르
    Integer runningTime; // 상영 시간

    public Movie(String title, String genre, Integer runningTime) {
        this.title = title;
        this.genre = genre;
        this.runningTime = runningTime;
    }
}
