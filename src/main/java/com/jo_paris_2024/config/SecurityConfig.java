package com.jo_paris_2024.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	
	
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .requestMatchers("/", "/api/v1/stades/**", "/api/v1/visiteurs/**").permitAll()

                .anyRequest().authenticated() // Authentification requise pour les autres requêtes
            .and()
            .httpBasic() // Activer l'authentification Basic
            .and()
            .csrf().disable(); // Désactiver CSRF pour les appels API
        return http.build();
    }

    // Configurer un utilisateur en mémoire avec un mot de passe
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
            .username("admin")
            .password(passwordEncoder.encode("admin123")) // Hacher le mot de passe avec BCrypt
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}