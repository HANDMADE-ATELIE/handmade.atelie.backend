package com.handmade.atelie.backend.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                    //Adicionar autorizações de acesso a endpoints aqui!
                    .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/user/registerCustomerUser").permitAll()
                    .requestMatchers(HttpMethod.POST, "/user/registerAdminUser").permitAll()
                    .requestMatchers(HttpMethod.PUT, "/user/updateUser/{id}").permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/user/deleteUser/{id}").permitAll()
                    .requestMatchers(HttpMethod.GET, "/user/getUser/{id}").permitAll()
                    .requestMatchers(HttpMethod.POST, "/copybook/registerCopybook").permitAll()
                    .requestMatchers(HttpMethod.GET, "/copybook/getAllCopybooks").permitAll()
                    .requestMatchers(HttpMethod.PUT, "/copybook/updateCopybook/{id}").permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/copybook/deleteCopybook/{id}").permitAll()
                    .anyRequest().authenticated()

                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
