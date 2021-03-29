package org.prabh.rest.restdemo.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "greeting")
public class Greeting {
    private String name ;
    private String coffee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoffee() {
        return coffee;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }
}
