package com.example.restaurants.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderRequestDto {
    private long restaurantId;
    private long foodId;
    private int orderQuantity;
    private int orderPrice;

}
