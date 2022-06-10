package com.example.restaurants.model;

import com.example.restaurants.dto.OrderFoodDto;
import com.example.restaurants.dto.ReceiptDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Receipt {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private long restaurantId;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;

    @OneToMany //DB에서 저장된 것만 불어와서 넣어줘야한다
    @JoinColumn(name = "OrderFood_id")
    private List<OrderFood> foods = new ArrayList<>();

    public Receipt(ReceiptDto receiptDto) {
        this.restaurantId = receiptDto.getRestaurantId();
        this.restaurantName = receiptDto.getRestaurantName();
        this.deliveryFee = receiptDto.getDeliveryFee();
        this.totalPrice = receiptDto.getTotalPrice();
    }

    public void from(List<OrderFood> orderFoods) {
        for(OrderFood orderFood : orderFoods){
            this.foods.add(new OrderFood(orderFood));
        }
    }
}
