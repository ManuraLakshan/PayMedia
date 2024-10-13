package com.example.EMS.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .requestMatchers("/api/**").authenticated()
//                .and()
//                .httpBasic();
//        return http.build();
//    }
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
            .authorizeRequests()
            .requestMatchers("/api/employees", "/api/departments").hasRole("ADMIN") // Write operations
            .requestMatchers("/api/employees/**", "/api/departments/**").hasAnyRole("ADMIN", "USER") // Read operations
            .and()
            .httpBasic();

    return http.build();
}

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User.withUsername("empadmin")
                .password(passwordEncoder().encode("exam#123"))
                .roles("ADMIN").build();
        UserDetails user = User.withUsername("emp001")
                .password(passwordEncoder().encode("emppw#123"))
                .roles("USER").build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
