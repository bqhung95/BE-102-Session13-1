package com.example.springsecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Cấu hình SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Tắt CSRF vì đây là REST API (không dùng session/form)
                .csrf(csrf -> csrf.disable())

                // Cấu hình phân quyền cho các request
                .authorizeHttpRequests(auth -> auth
                        // Cho phép truy cập tự do vào các API auth (đăng ký/đăng nhập)
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        // Tất cả các request còn lại đều phải xác thực
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
