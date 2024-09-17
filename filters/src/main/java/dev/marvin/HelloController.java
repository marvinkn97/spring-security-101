package dev.marvin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")

public class HelloController {

    @GetMapping
    public String sayHello(){
        try {
            return new ObjectMapper().writeValueAsString("Hello");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
