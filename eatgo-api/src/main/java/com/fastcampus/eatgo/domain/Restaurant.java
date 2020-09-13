package com.fastcampus.eatgo.domain;

public class Restaurant {

    private final String name;
    private final String location;
    private final Long id;

    public Restaurant(Long id, String name, String location) {
        this.name = name;
        this.id = id;
        this.location = location;
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


}
