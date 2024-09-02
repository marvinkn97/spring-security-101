package dev.marvin.config;

import dev.marvin.service.userdetailsservice.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
public class UserManagementConfig {
    //@Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("marvin")
                .password("password")
                .authorities("READ", "WRITE")
                .accountExpired(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();

        return new InMemoryUserDetailsManager(user, user2);
    }

    @Bean
    public UserDetailsService userDetailsService2() {
        UserDetails user = User.builder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("marvin")
                .password("password")
                .authorities("READ", "WRITE")
                .accountExpired(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();

        return new InMemoryUserDetailsService(List.of(user, user2));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
