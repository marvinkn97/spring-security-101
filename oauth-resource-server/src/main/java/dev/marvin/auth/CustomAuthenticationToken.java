package dev.marvin.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;

public class CustomAuthenticationToken extends JwtAuthenticationToken {

    private final String priority;


    public CustomAuthenticationToken(Jwt jwt, Collection<? extends GrantedAuthority> authorities, String priority) {
        super(jwt, authorities);
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
