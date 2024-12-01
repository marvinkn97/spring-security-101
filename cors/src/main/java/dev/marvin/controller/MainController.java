package dev.marvin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@CrossOrigin("*")
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/")
    public String main(){
        return "main.html";
    }

    @PostMapping("/test")
    @ResponseBody
    public String test(){
        log.info("Test method called");
        return "Hello";
    }
}
