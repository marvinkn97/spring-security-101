package dev.marvin.csrf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String getHello(){
        return "GET Hello!";
    }

    @PostMapping
    public String postHello(){
        return "POST Hello!!";
    }

    @PostMapping("/ciao")
    public String postCiao(){
        return "POST Ciao!!";
    }

}
