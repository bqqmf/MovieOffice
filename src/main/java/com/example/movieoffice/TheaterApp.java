package com.example.movieoffice;

import com.example.movieoffice.theater.Theater;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TheaterApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        Theater cgv = ac.getBean(Theater.class);
        System.out.println("cgv = " + cgv);
    }
}
