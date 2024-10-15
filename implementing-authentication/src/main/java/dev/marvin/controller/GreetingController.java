package dev.marvin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/hello")
    public void sayHello(Authentication authentication){
        log.info("Authenticated user name: {}", authentication.getName());
    }

    @GetMapping("/hello2")
    @Async //run on a separate thread per request
    public void sayHello2(){
        log.info("Authenticated user name: {}", SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
