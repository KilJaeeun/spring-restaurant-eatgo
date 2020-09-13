package com.fastcampus.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//views.py
@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepositoryImpl() {

        Restaurant restaurant1 = new Restaurant(1004L, "Bob zip", "Seoul");
        Restaurant restaurant2 = new Restaurant(2020L, "Bob2 zip", "Seoul");
        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
    }

    @Override
    public List<Restaurant> findAll() {

        return restaurants;
    }

    @Override
    public Restaurant findById(Long id) {

        return restaurants.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null); //찾아서 겟하기



    }
}
