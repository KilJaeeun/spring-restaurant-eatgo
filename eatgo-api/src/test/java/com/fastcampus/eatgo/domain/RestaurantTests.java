package com.fastcampus.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantTests {
    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant(1004L,"Bob zip","Seoul" );
        assertThat(restaurant.getName(),is("Bob zip"));
        assertThat(restaurant.getId(),is(1004L));

        assertThat(restaurant.getLocation(),is("Seoul"));
    }
    @Test
    public void information(){
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");
        assertThat(restaurant.getInformation(),is("Bob zip in Seoul"));

    }
}