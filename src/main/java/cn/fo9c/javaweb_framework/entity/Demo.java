package cn.fo9c.javaweb_framework.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 使用Lombok注解简化代码
@Data
@NoArgsConstructor
@AllArgsConstructor

// 使用TableName注解指定表名
@TableName("user")
public class Demo {
    // 使用TableId注解指定主键
    @TableId

    private Integer uid;
    private String name;
    private int age;

}
