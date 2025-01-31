package dev.marvin.csrf.config;

import dev.marvin.csrf.filter.CsrfTokenLogger;
import dev.marvin.csrf.repository.CustomCsrfTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

@Configuration
public class SecurityConfig {
    private final CustomCsrfTokenRepository customCsrfTokenRepository;

    public SecurityConfig(CustomCsrfTokenRepository customCsrfTokenRepository) {
        this.customCsrfTokenRepository = customCsrfTokenRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(c -> c.ignoringRequestMatchers("/ciao")
                        .csrfTokenRepository(customCsrfTokenRepository)
                        .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler()))
                .addFilterAfter(new CsrfTokenLogger(), CsrfFilter.class)
                .authorizeHttpRequests(c -> c.anyRequest().authenticated())
                .formLogin(c -> c.defaultSuccessUrl("/main", true))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("marvin")
                .password(passwordEncoder().encode("password"))
                .authorities("READ")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
