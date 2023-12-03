package com.example.ratings;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {



    @GetMapping
    public String helloWorld(){
        return "hello world from ratings";
    }
}
