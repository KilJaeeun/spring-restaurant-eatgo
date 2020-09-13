package com.fastcampus.eatgo.interfaces;

import com.fastcampus.eatgo.domain.MenuItemRepository;
import com.fastcampus.eatgo.domain.MenuItemRepositoryImpl;
import com.fastcampus.eatgo.domain.RestaurantRepository;
import com.fastcampus.eatgo.domain.RestaurantRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;

import static org.hamcrest.Matchers.containsString;
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

    // 컨트롤러에 원하는 객체 주입
    @SpyBean(RestaurantRepositoryImpl.class)
    private RestaurantRepository restaurantRepository;
    @SpyBean(MenuItemRepositoryImpl.class)
    private MenuItemRepository menuItemRepository;
    @Test
    public void list() throws Exception {
        mvc.perform(get("/restaurants")).andExpect(status().isOk()).andExpect(content().string(

                containsString("\"name\":" +
                        "\"Bob zip\""))).andExpect(content().string(

                containsString("\"id\":" +
                        "1004")));// 이 데이터에서 문자열 이것이 포함되어있는지 확인

    }
    @Test
    public void detail() throws Exception {
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