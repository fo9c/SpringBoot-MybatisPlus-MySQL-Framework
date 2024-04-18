package cn.fo9c.javaweb_framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

// 通过exclude属性排除数据库相关的自动配置,删去exclude属性会严重构建出错
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class JavaWebFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaWebFrameworkApplication.class, args);
        System.out.println("JavaWebFrameworkApplication is running!");
    }

}
