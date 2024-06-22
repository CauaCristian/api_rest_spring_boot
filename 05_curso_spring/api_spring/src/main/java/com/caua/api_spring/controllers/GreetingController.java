package com.caua.api_spring.controllers;

import com.caua.api_spring.models.GreetingModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    public static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping("/")
    public GreetingModel greeting(@RequestParam(value = "name",defaultValue = "world")String name){
        return new GreetingModel(counter.incrementAndGet(), String.format(template,name));
    };
}
