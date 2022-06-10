package com.example.restaurants.service;

import com.example.restaurants.dto.FoodRequestDto;
import com.example.restaurants.model.Food;
import com.example.restaurants.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }
    public void postFood(long restaurantId, List<FoodRequestDto> foodRequestDto) {
        List<Food> test = foodRepository.findAllByRestaurantId(restaurantId);

        List<Food> food = new ArrayList<>();

        for(Food tempTest : test){
            for(FoodRequestDto tempFood: foodRequestDto){
                if(tempTest.getName().equals(tempFood.getName())){
                    throw new RuntimeException("음식명이 중복 됩니다");
                }
            }
        }

        Set<String> foodSet = new HashSet<>();

        for (FoodRequestDto tempFood : foodRequestDto){
            foodSet.add(tempFood.getName());
        }

        if(!(foodSet.size()  == foodRequestDto.size())){
            throw new RuntimeException("입력하려는 값에 동일한 음식명이 존재합니다");
        }

        for(FoodRequestDto tempfood : foodRequestDto){
            if(tempfood.getPrice() < 100 || tempfood.getPrice() > 1000000){
                throw new RuntimeException("가격을 재설정 해주세요");
            }
            if(tempfood.getPrice() % 100 != 0){
                throw new RuntimeException("100원 단위로 입력해주세요");
            }
        }

        for(FoodRequestDto tempFood: foodRequestDto){
            food.add(new Food(restaurantId, tempFood));
        }

        foodRepository.saveAll(food);

    }

    public List<Food> getFood(long restaurantId) {
        List<Food> foods = foodRepository.findAllByRestaurantId(restaurantId);
        return foods;
    }
}
