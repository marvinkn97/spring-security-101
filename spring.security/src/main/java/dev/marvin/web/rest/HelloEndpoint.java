package dev.marvin.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/hello")
public class HelloEndpoint {

    @GetMapping
    public String sayHello() {
        return "Hello";
    }
}
