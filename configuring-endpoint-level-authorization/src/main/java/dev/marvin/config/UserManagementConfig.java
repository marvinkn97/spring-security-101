package dev.marvin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        var manager = new InMemoryUserDetailsManager();

//        var user1 = User.withUsername("marvin")
//                .password("password")
//                .authorities("READ")
//                .build();
//
//        var user2 = User.withUsername("rita")
//                .password("password")
//                .authorities("WRITE")
//                .build();


        // having the ROLE_prefix, GrantedAuthority now represents a role
        var user1 = User.withUsername("marvin")
                .password("password")
                .authorities("ROLE_ADMIN")
                .build();

        var user2 = User.withUsername("rita")
                .password("password")
                .authorities("ROLE_MANAGER")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
//        return new BCryptPasswordEncoder();
    }
}
