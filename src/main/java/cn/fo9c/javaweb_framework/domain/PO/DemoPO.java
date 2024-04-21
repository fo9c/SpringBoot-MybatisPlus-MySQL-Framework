package cn.fo9c.javaweb_framework.domain.PO;

import com.baomidou.mybatisplus.annotation.TableField;
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
// 定义PO类,用于映射数据库表
public class DemoPO {
    // 使用TableId注解指定主键
    @TableId
    private Integer uid;
    @TableField(value = "name")
    private String name;
    @TableField(value = "age")
    private int age;

}
