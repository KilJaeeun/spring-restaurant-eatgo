package com.fastcampus.eatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final String name;
    private final String location;
    private final Long id;
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public Restaurant(Long id, String name, String location) {
        this.name = name;
        this.id = id;
        this.location = location;

    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        //    this.menuItems = menuItems;


        for (MenuItem menuItem : menuItems) {
            addMenuItem(menuItem);
        }

    }

    public String getLocation() {
        return location;
    }

    public Object getName() {
        return this.name;
    }

    public Object getInformation() {
        return this.name + " in " + this.location;
    }

    public Long getId() {

        return id;
    }


    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }


}
