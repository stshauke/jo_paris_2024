package com.jo_paris_2024.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .requestMatchers("/", "/stade", "/api/v1/stades/**").permitAll() // Autoriser l'accès public à ces URL
                .anyRequest().authenticated() // Authentification requise pour les autres requêtes
            .and()
            .httpBasic() // Activer l'authentification Basic
            .and()
            .csrf().disable(); // Désactiver CSRF pour les appels API
        return http.build();
    }

    // Configurer un utilisateur en mémoire avec un mot de passe
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder() // Utilisation de Basic Auth avec un utilisateur en mémoire
            .username("admin")
            .password("admin123")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
