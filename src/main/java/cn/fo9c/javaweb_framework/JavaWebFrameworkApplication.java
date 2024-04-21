package cn.fo9c.javaweb_framework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@MapperScan("cn.fo9c.javaweb_framework.mapper")
public class JavaWebFrameworkApplication {

    public static void main(String[] args) {

        // 新启动项追加路径显示
        ConfigurableApplicationContext application = SpringApplication.run(JavaWebFrameworkApplication.class, args);
        Environment env = application.getEnvironment();
        String port = env.getProperty("server.port");
        String property = env.getProperty("server.servlet.context-path");
        String path = property == null ? "" :  property;
        System.out.println(
                        "———————————————————————————————————————————————————————————————————————————————————————————————————————————\n\t" +
                        "         Access URLs:\thttp://localhost:" + port + path + "              SpringBoot   Version: 3.2.4 \n\t" +
                        "         DataBase: MySQL                                   Mybatis-Plus Version: 3.5.5\n" +
                        "———————————————————————————————————————————————————————————————————————————————————————————————————————————");
    }
}



/*
严重错误记录: 无法自动装配Bean
不能通过exclude属性排除数据库相关的自动配置,会导致BeanFactory无法创建正常工作,影响Mapper的自动注入
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
 */