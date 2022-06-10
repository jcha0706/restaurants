package com.example.restaurants.model;

import com.example.restaurants.dto.FoodRequestDto;
import com.example.restaurants.dto.RestaurantsRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Food {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private long restaurantId;

    public Food(long restaurantId, FoodRequestDto foodRequestDto) {
        this.name = foodRequestDto.getName();
        this.price = foodRequestDto.getPrice();
        this.restaurantId = restaurantId;
    }
}
