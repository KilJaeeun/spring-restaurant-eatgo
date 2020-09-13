package com.fastcampus.eatgo.interfaces;


import com.fastcampus.eatgo.domain.MenuItem;
import com.fastcampus.eatgo.domain.MenuItemRepository;
import com.fastcampus.eatgo.domain.Restaurant;
import com.fastcampus.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


//urls.py
@RestController
public class RestaurantController {
    @Autowired //spring 이 알아서 객체 생성해줌.
    private RestaurantRepository restaurantRepositoryy ;
    @Autowired //spring 이 알아서 객체 생성해줌.
    private MenuItemRepository menuItemRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = restaurantRepositoryy.findAll();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantRepositoryy.findById(id);
        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);
        return restaurant;
    }

}
