package cn.fo9c.javaweb_framework.mapper;

import cn.fo9c.javaweb_framework.entity.Demo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


// 继承BaseMapper接口,泛型指定实体类,简化CRUD操作
public interface DemoMapper extends BaseMapper<Demo> {
}
