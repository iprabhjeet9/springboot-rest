package org.prabh.rest.restdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Value("${greeting-name: No one}")
    String name;

    @Value("${greeting: ${greeting-name} is present.}")
    String msg;

    @GetMapping("/greets")
    String getName(){
        return name;
    }

    @GetMapping("/msg")
    String getMsg(){
        return msg;
    }
}
