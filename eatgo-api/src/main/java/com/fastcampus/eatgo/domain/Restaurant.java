package com.fastcampus.eatgo.domain;

public class Restaurant {

    private final String name;
    private final String location;

    public Restaurant(String name, String location) {
    this.name= name;
    this.location=location;
    }

    public String getLocation() {
        return location;
    }

    public Object getName() {
        return this.name;
    }

    public Object getInformation() {
        return this.name+" in "+this.location;
    }
}
