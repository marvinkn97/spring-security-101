package dev.marvin.config;

import dev.marvin.auth.CustomJwtConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final CustomJwtConverter jwtConverter;

    @Value("${keySetURI}")
    private String keySetURI;

    public SecurityConfig(CustomJwtConverter jwtConverter) {
        this.jwtConverter = jwtConverter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.oauth2ResourceServer(c -> c.jwt(j -> {
                    j.jwkSetUri(keySetURI);
                    j.jwtAuthenticationConverter(jwtConverter);
                }
        ));

        httpSecurity.authorizeHttpRequests(c -> c.anyRequest().authenticated());

        return httpSecurity.build();
    }
}
