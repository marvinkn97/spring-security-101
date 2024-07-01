package dev.marvin.config;

import dev.marvin.filter.AuthenticationLoggingFilter;
import dev.marvin.filter.RequestValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final CustomAuthenticationProvider authenticationProvider;

    public SecurityConfig(CustomAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authenticationProvider(authenticationProvider)
                .cors(Customizer.withDefaults())
                .addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

}
