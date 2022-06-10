package com.example.restaurants.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderFoodDto {
    private long id;
    private int quantity;
    private String name;
    private int price;
}
