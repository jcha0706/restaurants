package com.example.restaurants.service;

import com.example.restaurants.dto.RestaurantsRequestDto;
import com.example.restaurants.model.Restaurants;
import com.example.restaurants.repository.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RestaurantsService {

    private final RestaurantsRepository restaurantsRepository;

    @Autowired
    public RestaurantsService(RestaurantsRepository restaurantsRepository){
        this.restaurantsRepository = restaurantsRepository;
    }

    public Restaurants postRestaurants(RestaurantsRequestDto requestDto) throws SQLException{
        Restaurants restaurants = new Restaurants(requestDto);

        if(requestDto.getMinOrderPrice() < 1000 || requestDto.getMinOrderPrice() > 100000){
            throw new RuntimeException("최소 주문 가격을 재설정 해주세요");
        }
        if(requestDto.getMinOrderPrice() % 100 != 0){
            throw new RuntimeException("100원 단위로 입력해 주세요");
        }

        if(requestDto.getDeliveryFee() < 0 || requestDto.getDeliveryFee() > 10000){
            throw new RuntimeException("기본 배달비 재설정 해주세요");
        }
        if(requestDto.getDeliveryFee() % 500 != 0){
            throw new RuntimeException("500원 단위로만 입력해 주세요");
        }


        restaurantsRepository.save(restaurants);
        return restaurants;
    }

    public List<Restaurants> getResaurants() throws SQLException{
        List<Restaurants> restaurants = restaurantsRepository.findAll();
        return restaurants;
    }

}
