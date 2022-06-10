package com.example.restaurants.controller;

import com.example.restaurants.dto.RestaurantsRequestDto;
import com.example.restaurants.model.Restaurants;
import com.example.restaurants.service.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class RestaurantsController {
    private final RestaurantsService restaurantsService;

    @Autowired
    public RestaurantsController(RestaurantsService restaurantsService){
        this.restaurantsService = restaurantsService;
    }

    //신규 음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurants postRestaurants(@RequestBody RestaurantsRequestDto requestDto) throws SQLException{
        Restaurants restaurants = restaurantsService.postRestaurants(requestDto);
        return restaurants;
    }

    //등록된 전체 음식점 목록 조회회
    @GetMapping("/restaurants")
    public List<Restaurants> getRestaurants() throws SQLException{
        List<Restaurants> restaurants = restaurantsService.getResaurants();
        return restaurants;
    }


}
