package dev.marvin.config;

import dev.marvin.filter.StaticKeyValidationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final CorsConfigurationSource corsConfigurationSource;
    private final StaticKeyValidationFilter staticKeyValidationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfigurationSource))
                //.addFilterBefore(new HelloFilter(), BasicAuthenticationFilter.class)
                //.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
                //.addFilterAt(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class)
                .addFilterAt(staticKeyValidationFilter, BasicAuthenticationFilter.class)
                .authorizeHttpRequests(request -> request.anyRequest().permitAll())
//                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
