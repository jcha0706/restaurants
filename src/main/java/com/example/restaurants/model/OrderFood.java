package com.example.restaurants.model;

import com.example.restaurants.dto.OrderFoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderFood {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    public OrderFood(OrderFood orderFood) {
        this.id = orderFood.getId();
        this.quantity = orderFood.getQuantity();
        this.name = orderFood.getName();
        this.price = orderFood.getPrice();
    }

    public OrderFood(OrderFoodDto orderFoodDto) {
        this.id = orderFoodDto.getId();
        this.quantity = orderFoodDto.getQuantity();
        this.name = orderFoodDto.getName();
        this.price = orderFoodDto.getPrice();
    }
}
