package com.example.restaurants.repository;

import com.example.restaurants.model.Food;
import com.example.restaurants.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {
    List<Food> findAllByRestaurantId(long restaurantId);
}
