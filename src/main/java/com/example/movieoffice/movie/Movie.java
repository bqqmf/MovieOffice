package com.example.movieoffice.movie;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Movie {
    private final String title; // 영화 제목
    private final String genre; // 영화 장르
    private final Integer runningTime; // 상영 시간


}
