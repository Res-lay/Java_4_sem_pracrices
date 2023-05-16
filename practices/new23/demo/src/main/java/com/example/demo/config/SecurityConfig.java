package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{
    @Autowired
    private com.example.demo.service.UserAppService userAppService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    @SuppressWarnings("deprecation")
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
            .cors().disable()
            .authorizeRequests()
            .requestMatchers("/reg", "/login").permitAll()
            .anyRequest().authenticated()
            .and().formLogin()
            .and().logout()
            .and().userDetailsService(userAppService);


        return httpSecurity.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userAppService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }
}
