package cn.fo9c.javaweb_framework.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 使用Lombok注解简化代码
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 定义VO类,该类是用于返回前端进行展示的类(回传)
public class DemoVO {
    private Integer uid;
    private String name;
    private int age;

}
