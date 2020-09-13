package com.fastcampus.eatgo.application;

import com.fastcampus.eatgo.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class RestaurantServiceTest {
    private RestaurantService restaurantService;
    @Mock //가짜 객체
    private RestaurantRepository restaurantRepository;
    @Mock //가짜 객체
    private MenuItemRepository menuItemRepository;

    // 스프링이 해줄수 없는 작업들을 미리 한다, 예) 서비스와 레포지토리 연결
    @Before //모든 테스트 시작전에 반드시 이것을 해본다.
    public void setUp() {
        MockitoAnnotations.initMocks(this);//가짜객체 초기화들
        //        restaurantRepository = new RestaurantRepositoryImpl();
        //        menuItemRepository = new MenuItemRepositoryImpl();
        mockRestaurantRespository();
        mockMenuItemRespository();
        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);

    }

    private void mockMenuItemRespository() {

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Kimchi"));
        given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(menuItems);
        
        
        
    }

    private void mockRestaurantRespository() {
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant1 = new Restaurant(1004L, "Bob zip", "Seoul");
        Restaurant restaurant2 = new Restaurant(2020L, "Bob2 zip", "Seoul");

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        given(restaurantRepository.findById(1004L)).willReturn(restaurant1);
        given(restaurantRepository.findAll()).willReturn(restaurants);
    }


    @Test
    public void getRestaurant() {
        Restaurant restaurant = restaurantService.getRestaurant(1004L);
        assertThat(restaurant.getId(), is(1004L));
        MenuItem menuItem = restaurant.getMenuItems().get(0);
        assertThat(menuItem.getName(), is("Kimchi"));

    }

    @Test
    public void getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        assertThat(restaurants.get(0).getId(), is(1004L));

    }

}