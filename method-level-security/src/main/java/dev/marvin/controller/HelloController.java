package dev.marvin.controller;

import dev.marvin.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final NameService nameService;

    @Autowired
    public HelloController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello, " + nameService.getName();
    }
}
