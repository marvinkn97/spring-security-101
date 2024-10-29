package dev.marvin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebAuthConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.authorizeHttpRequests(c -> {
//            c.anyRequest().permitAll();
            c.anyRequest().hasAuthority("WRITE");
        });

        return httpSecurity.build();
    }
}
