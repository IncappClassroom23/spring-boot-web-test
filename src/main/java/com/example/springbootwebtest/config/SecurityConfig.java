package com.example.springbootwebtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.GET, "/uploadFile","downloadFile").authenticated()
                        .requestMatchers(HttpMethod.POST,"/upload","/download").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/note/**","/getNoteById/**").authenticated()
                        .requestMatchers(HttpMethod.POST,"/api/note/**").authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }
}
