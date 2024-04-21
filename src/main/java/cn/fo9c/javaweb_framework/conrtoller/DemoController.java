package cn.fo9c.javaweb_framework.conrtoller;

import cn.fo9c.javaweb_framework.entity.Demo;
import cn.fo9c.javaweb_framework.mapper.DemoMapper;
import cn.fo9c.javaweb_framework.utils.SnowFlakeID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 使用RestController注解标记这是一个控制器
@RestController
public class DemoController {
    // 使用字段或者构造器注入DemoMapper，实现数据访问
    @Autowired
    private DemoMapper demoMapper;
//    private final DemoMapper demoMapper;
//
//    public DemoController(DemoMapper demoMapper) {
//        this.demoMapper = demoMapper;
//    }

    @GetMapping("/user")
    public List<Demo> getDemoList() {
        SnowFlakeID snowFlakeID1 = new SnowFlakeID();
        System.out.println(snowFlakeID1.generator());
        return demoMapper.selectList(null);
    }


}
