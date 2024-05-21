package cn.fo9c.javaweb_framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

// @EnableWebSecurity注解开启Spring Security的功能
@Component
@EnableWebSecurity
public class SecurityConfig {

    /*
    生成的加密密码示例:
    rawPassword:        123456
    encodedPassword:    $2a$10$Mw2QqlCOqhKkWyYLjJWKfOhnPXCZb5CSlpZ9qWixT7/onsX1omPGe
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
