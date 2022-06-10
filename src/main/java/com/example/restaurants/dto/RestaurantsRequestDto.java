package com.example.restaurants.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RestaurantsRequestDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}
