package dev.marvin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
public class UserManagementConfig {

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails admin = User.withUsername("Admin")
                .password("password")
                .roles("ADMIN")
                .disabled(false)
                .build();

        UserDetails user = User.withUsername("User")
                .password("password")
                .roles("USER")
                .disabled(false)
                .build();

        return new InMemoryUserDetailsManager(List.of(admin, user));
    }
}
