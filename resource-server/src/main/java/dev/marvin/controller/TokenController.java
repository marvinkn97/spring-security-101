package dev.marvin.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("api/v1/token")

public class TokenController {

    @GetMapping
    public Map<String, Object> getToken(@AuthenticationPrincipal Jwt jwt){
        return Collections.singletonMap("principal", jwt);
    }
}
