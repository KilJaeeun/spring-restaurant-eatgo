package com.fastcampus.eatgo.interfaces;

import com.fastcampus.eatgo.application.RestaurantService;
import com.fastcampus.eatgo.domain.*;
import com.fastcampus.eatgo.domain.MenuItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//스프링을 이용해서 이 테스트를 진행해라.
// 안쓰는 import 정리 ctrl alt o
@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class) //이 컨트롤러를 검사해라.
public class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;
//
//    // 컨트롤러에 원하는 객체 주입
//    @SpyBean(RestaurantRepositoryImpl.class)
//    private RestaurantRepository restaurantRepository;

    // 가짜 객체 만들기: 의존성 있는 친구들을 진짜 만드는 것이 아니라 가짜로 만들어준다.
    @MockBean
    private RestaurantService restaurantService;

        //    @SpyBean(RestaurantService.class)
    //    private RestaurantService restaurantService;
    //    @SpyBean(MenuItemRepositoryImpl.class)
    //    private MenuItemRepository menuItemRepository;

    @Test
    public void list() throws Exception {



        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Bob2 zip", "Seoul"));
        given(restaurantService.getRestaurants()).willReturn(restaurants);// 가짜로 데이터 삽입
        
        
        mvc.perform(get("/restaurants")).andExpect(status().isOk()).andExpect(content().string(

                containsString("\"name\":" +
                        "\"Bob zip\""))).andExpect(content().string(

                containsString("\"id\":" +
                        "1004")));// 이 데이터에서 문자열 이것이 포함되어있는지 확인

    }

    @Test
    public void detail() throws Exception {


        Restaurant restaurant1 = new Restaurant(1004L, "Bob zip", "Seoul");
        Restaurant restaurant2 = new Restaurant(2020L, "Bob2 zip", "Seoul");
        restaurant1.addMenuItem(new MenuItem("Kimchi"));
        given(restaurantService.getRestaurant(1004L)).willReturn(restaurant1);
        given(restaurantService.getRestaurant(2020L)).willReturn(restaurant2);

        
        
        mvc.perform(get("/restaurants/1004")).andExpect(status().isOk()).andExpect(content().string(

                containsString("\"name\":" +
                        "\"Bob zip\""))).andExpect(content().string(

                containsString("\"id\":" +
                        "1004"))).andExpect(content().string(

                containsString("Kimchi")));// 이 데이터에서 문자열 이것이 포함되어있는지 확인
        mvc.perform(get("/restaurants/2020")).andExpect(status().isOk()).andExpect(content().string(

                containsString("\"name\":" +
                        "\"Bob2 zip\""))).andExpect(content().string(

                containsString("\"id\":" +
                        "2020")));// 이 데이터에서 문자열 이것이 포함되어있는지 확인

    }
}