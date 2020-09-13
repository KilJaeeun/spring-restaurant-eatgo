package com.fastcampus.eatgo.interfaces;


import com.fastcampus.eatgo.application.RestaurantService;
import com.fastcampus.eatgo.domain.MenuItem;
import com.fastcampus.eatgo.domain.MenuItemRepository;
import com.fastcampus.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


//urls.py
@RestController
public class RestaurantController {
//    @Autowired //spring 이 알아서 객체 생성해줌.
//    private RestaurantRepository restaurantRepository;
    @Autowired //spring 이 알아서 객체 생성해줌.
    private MenuItemRepository menuItemRepository;
    @Autowired //spring 이 알아서 객체 생성해줌.
    private RestaurantService restaurantService;
    @GetMapping("/restaurants")
    public List<Restaurant> list() {
       // List<Restaurant> restaurants = restaurantRepository.findAll();
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        //기본 정보 메뉴 정보
  //      Restaurant restaurantService = restaurantRepository.findById(id);

        return restaurant;
    }

}
