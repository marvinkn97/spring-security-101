package dev.marvin.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/")
    public String secure(OAuth2AuthenticationToken oAuth2AuthenticationToken){
        return "secure" + oAuth2AuthenticationToken;
    }
}
