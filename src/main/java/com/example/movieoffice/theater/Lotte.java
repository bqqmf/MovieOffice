package com.example.movieoffice.theater;

import com.example.movieoffice.customer.Customer;
import com.example.movieoffice.customer.CustomerRepository;
import com.example.movieoffice.discount.DiscountPolicy;
import com.example.movieoffice.movie.Movie;
import com.example.movieoffice.movie.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Lotte implements Theater {
    private final MovieRepository movieRepository; // 영화들을 가지는 객체
    private final CustomerRepository customerRepository; // 손님 정보를 갖는 객체
    private final DiscountPolicy discountPolicy; // 할인 가격을 알려주는 객체

    private final TheaterType type = TheaterType.LOTTE; // 영화관 종류
    private final int moviePrice = 11000; // 영화 가격
    private int money = 0; // 영화관이 가진 돈


    @Override
    public Movie book(Long id, String title) {
        Customer customer = customerRepository.retrieve(id); // id 로 고객 조회
        this.money += this.moviePrice - this.getDiscountedPrice(customer, moviePrice); // 영화관이 받은 돈 증가
        return movieRepository.retrieve(title); // 영화 리턴
    }

    @Override
    public void printMovies() {
        for (Movie movie : this.getMovies()) {
            System.out.println("movie = " + movie);
        }
    }

    @Override
    public TheaterType getType() {
        return this.type;
    }

    @Override
    public List<Movie> getMovies() {
        return this.movieRepository.getMovies();
    }

    @Override
    public void registerMovie(Movie movie) {
        this.movieRepository.save(movie);
    }

    @Override
    public void join(Customer customer) {
        this.customerRepository.save(customer);
    }

    private Movie findMovie(String title) {
        return this.movieRepository.retrieve(title);
    }

    private Customer findCustomer(Long customerId) {
        return this.customerRepository.retrieve(customerId);
    }

    private int getDiscountedPrice(Customer customer, int price) {
        return discountPolicy.discount(customer, price);
    }
}
