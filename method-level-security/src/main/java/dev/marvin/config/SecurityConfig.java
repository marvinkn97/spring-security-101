package dev.marvin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import permissionevaluator.DocumentPermissionEvaluator;

import java.util.List;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(Customizer.withDefaults())
                .csrf(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }


    @Bean
    public UserDetailsService userDetailsService(){

        var u1 = User.withUsername("marvin")
                .password(passwordEncoder().encode("password"))
                .authorities("READ")
                .build();

        var u2 = User.withUsername("rita")
                .password(passwordEncoder().encode("password"))
                .authorities("WRITE")
                .build();

        return new InMemoryUserDetailsManager(List.of(u1, u2));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public PermissionEvaluator permissionEvaluator(){
        return new DocumentPermissionEvaluator();
    }

    @Bean
    public MethodSecurityExpressionHandler methodSecurityExpressionHandler(PermissionEvaluator permissionEvaluator){
        var exceptionHandler = new DefaultMethodSecurityExpressionHandler();
        exceptionHandler.setPermissionEvaluator(permissionEvaluator);
        return exceptionHandler;
    }

}
