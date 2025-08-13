package io.university.gunadarma.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        var h2ConsoleMatcher = PathRequest.toH2Console();

        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/actuator/health", "/actuator/info", "/actuator/metrics/**").permitAll()
                .requestMatchers(h2ConsoleMatcher).permitAll()
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf
                .ignoringRequestMatchers(h2ConsoleMatcher)
            )
            .headers(headers -> headers
                .frameOptions(frame -> frame.disable()) // only for H2-console frames
            );
        // Default form login remains enabled
        return http.build();
    }
}
