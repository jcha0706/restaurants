package com.example.restaurants.repository;

import com.example.restaurants.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantsRepository extends JpaRepository<Restaurants,Long> {
}
