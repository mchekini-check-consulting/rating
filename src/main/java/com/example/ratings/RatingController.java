package com.example.ratings;


import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

    private final RatingRepository ratingRepository;

    public RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @GetMapping
    public String helloWorld(){
        return "hello world from ratings";
    }

    @PostConstruct
    private void populate() {
        Rating rating = Rating.builder().id("rating from docker").productId(1000L).rate(5).build();
        this.ratingRepository.save(rating);
    }
}
