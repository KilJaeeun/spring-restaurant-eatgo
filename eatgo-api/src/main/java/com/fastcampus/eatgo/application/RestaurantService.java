package com.fastcampus.eatgo.application;

import com.fastcampus.eatgo.domain.*;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


// 한 개 모델이 아니라 여러개의 모델을 조합하는 복잡한 구조를 실현하기 위해 만드는 것이 서비스라 생각됨.
@Service // 서비스는  서비스라 붙인
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    public Restaurant getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id);
        return restaurant;
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }
}
