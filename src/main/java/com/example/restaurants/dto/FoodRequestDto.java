package com.example.restaurants.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FoodRequestDto {
    private String name;
    private int price;
    private long restaurantId;
}
