package com.example.restaurants.controller;

import com.example.restaurants.dto.FoodRequestDto;
import com.example.restaurants.model.Food;
import com.example.restaurants.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    private final FoodService foodService;


    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void postFood(@PathVariable long restaurantId, @RequestBody List<FoodRequestDto> foodRequestDto){
        foodService.postFood(restaurantId, foodRequestDto);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFood(@PathVariable long restaurantId){
        List<Food> foods = foodService.getFood(restaurantId);
        return foods;
    }


}
