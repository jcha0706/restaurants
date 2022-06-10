package com.example.restaurants.service;

import com.example.restaurants.dto.OrderFoodDto;
import com.example.restaurants.dto.ReceiptDto;
import com.example.restaurants.model.OrderFood;
import com.example.restaurants.model.Orders;
import com.example.restaurants.model.Receipt;
import com.example.restaurants.model.Restaurants;
import com.example.restaurants.repository.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;
    private final RestaurantsRepository restaurantsRepository;
    private final ReceiptRepository receiptRepository;
    private final OrderFoodRepository orderFoodRepository;

    public OrderService(OrderRepository orderRepository, FoodRepository foodRepository, RestaurantsRepository restaurantsRepository, ReceiptRepository receiptRepository, OrderFoodRepository orderFoodRepository) {
        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
        this.restaurantsRepository = restaurantsRepository;
        this.receiptRepository = receiptRepository;
        this.orderFoodRepository = orderFoodRepository;
    }

    public Receipt postOrder(ReceiptDto receiptDto){

        for(OrderFoodDto orderFoods : receiptDto.getFoods()){
            if(orderFoods.getQuantity() < 1 || orderFoods.getQuantity() > 100){
                throw new RuntimeException("수량을 다시 설정해 주세요");
            }
        }

        int total = 0;
        for(OrderFoodDto orderFoods : receiptDto.getFoods()){
            orderFoods.setName(foodRepository.findById(orderFoods.getId()).get().getName());
            orderFoods.setPrice(orderFoods.getQuantity()*foodRepository.findById(orderFoods.getId()).get().getPrice());
            total += orderFoods.getPrice();
        }

        Restaurants temp = restaurantsRepository.findById(receiptDto.getRestaurantId()).get();
        receiptDto.setDeliveryFee(temp.getDeliveryFee());
        int totalPrice = total + receiptDto.getDeliveryFee();
        receiptDto.setTotalPrice(totalPrice);
        receiptDto.setRestaurantName(temp.getName());



        Receipt receipt = new Receipt(receiptDto);
        List<OrderFood> orderFood = new ArrayList<>();
        for(OrderFoodDto orderFoodDto : receiptDto.getFoods()){
            orderFood.add(new OrderFood(orderFoodDto));
        }


        List<OrderFood> orderFoods = orderFoodRepository.saveAll(orderFood);
        receipt.from(orderFoods);

        receiptRepository.save(receipt);


        return receiptRepository.findById(receipt.getId()).get();
    }

    public List<Orders> getOrder() throws SQLException {
        List<Orders> orders = orderRepository.findAll();
        return orders;
    }
}
