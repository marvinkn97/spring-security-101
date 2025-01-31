package dev.marvin.config;

import dev.marvin.authenticationprovider.CustomAuthenticationProvider;
import dev.marvin.authentrypoint.CustomAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    public SecurityConfig(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    //@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authenticationProvider(customAuthenticationProvider)
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    //@Bean
    public SecurityFilterChain securityFilterChain2(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authenticationProvider(customAuthenticationProvider)
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(c -> {
                    c.realmName("OTHER");
                    c.authenticationEntryPoint(new CustomAuthenticationEntryPoint());
                })
                .build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain3(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authenticationProvider(customAuthenticationProvider)
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .build();
    }

}
