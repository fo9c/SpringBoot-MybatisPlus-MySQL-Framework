package cn.fo9c.javaweb_framework.conrtoller;

import cn.fo9c.javaweb_framework.entity.Demo;
import cn.fo9c.javaweb_framework.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 使用RestController注解标记这是一个控制器
@RestController
public class DemoController {
    // 自动注入DemoMapper，实现数据访问
    @Autowired
    private DemoMapper demoMapper;


    @GetMapping("/user")
    public List<Demo> getDemoList() {
        return demoMapper.selectList(null);
    }


}
