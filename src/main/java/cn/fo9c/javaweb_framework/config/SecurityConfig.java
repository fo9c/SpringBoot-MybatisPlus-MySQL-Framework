package cn.fo9c.javaweb_framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
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



//
//    // 重写AuthenticationManager，用于认证
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)              // 关闭否则csrf,异域请求会被拦截
//                .formLogin(form -> form
//                        .loginPage("/login")                    // 自定义登录页面URL
//                        .loginProcessingUrl("/login")           // 自定义登录处理URL
//                        .successForwardUrl("/user/all")    // 登录成功后跳转URL
//                        .failureForwardUrl("/user/all")    // 登录失败后跳转URL
//
//                );
//
//        // 构建过滤链并返回
//        return http.build();
//    }
//



}
