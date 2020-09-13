package com.fastcampus.eatgo.application;

import com.fastcampus.eatgo.domain.Restaurant;
import com.fastcampus.eatgo.domain.RestaurantRepository;
import com.fastcampus.eatgo.domain.RestaurantRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantServiceTest {
    private RestaurantService restaurantService;

    private RestaurantRepository restaurantRepository;

    // 스프링이 해줄수 없는 작업들을 미리 한다, 예) 서비스와 레포지토리 연결
    @Before //모든 테스트 시작전에 반드시 이것을 해본다.
    public void setUp() {

        restaurantRepository = new RestaurantRepositoryImpl();
        restaurantService = new RestaurantService(restaurantRepository);

    }


    @Test
    public void getRestaurantById() {
        Restaurant restaurant = restaurantService.getRestaurant(1004L);
        assertThat(restaurant.getId(), is(1004L));

    }

    @Test
    public void getRestaurants(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        assertThat(restaurants.get(0).getId(), is(1004L));

    }

}