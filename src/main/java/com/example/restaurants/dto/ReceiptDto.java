package com.example.restaurants.dto;

import com.example.restaurants.model.OrderFood;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReceiptDto {
    private long restaurantId;
    private String restaurantName;
    private int deliveryFee;
    private int totalPrice;
    private List<OrderFoodDto> foods = new ArrayList<>();

}
