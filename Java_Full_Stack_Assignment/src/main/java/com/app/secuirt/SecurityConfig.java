package com.app.secuirt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for APIs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll() // allow your login endpoint
                .anyRequest().authenticated() // protect everything else
            )
            .formLogin(form -> form.disable()) // disable default login page
            .httpBasic(basic -> basic.disable()); // disable basic auth

        return http.build();
    }
}
