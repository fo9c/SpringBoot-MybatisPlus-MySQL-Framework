package cn.fo9c.javaweb_framework.conrtoller;

import cn.fo9c.javaweb_framework.domain.Demo.DemoDTO;
import cn.fo9c.javaweb_framework.domain.Demo.DemoPO;
import cn.fo9c.javaweb_framework.utils.ResponseResult;
import cn.fo9c.javaweb_framework.domain.Demo.DemoVO;
import cn.fo9c.javaweb_framework.mapper.DemoMapper;
import cn.fo9c.javaweb_framework.service.DemoService;
import cn.fo9c.javaweb_framework.utils.SnowFlakeID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

// 使用RestController注解标记这是一个控制器
@RestController
@RequestMapping("/user")
public class UserController {

    // 使用字段或者构造器注入DemoMapper，实现数据访问
    @Autowired
    private DemoMapper demoMapper;
    @Autowired
    private DemoService demoService;

    // 使用LoggerFactory创建日志记录器
    Logger logger = LoggerFactory.getLogger(UserController.class);


    /**
     * 获取用户列表
     */
    @GetMapping("/all")
    public List<DemoPO> getDemoList() {
        SnowFlakeID snowFlakeID1 = new SnowFlakeID();

        logger.info("雪花ID1: " + snowFlakeID1.generator());
        logger.info("获取用户列表");
        return demoMapper.selectList(null);
    }


    /**
     * 添加用户
     * @param demoDTO 用户信息
     */
    @PostMapping("/find")
    public ResponseResult<DemoVO> findUserByUid(@RequestBody DemoDTO demoDTO) {
        DemoVO demoVO = demoService.getDemoInfoByUid(demoDTO);
        if (demoVO == null) {
            logger.error("查询失败");
            return ResponseResult.error("查询失败",new HashMap<>());
        }
        logger.info("查询成功");
        return ResponseResult.success("查询成功", demoVO);
    }


    /**
     * 添加用户
     */
    @GetMapping("/register")
    public String createUserAccount() {

        // 创建BCryptPasswordEncoder实例,用于加密密码
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        logger.info("加密后的密码：" + encode);
        System.out.println(encode);
        System.out.println(bCryptPasswordEncoder.matches("123456", encode));
        System.out.println("------------------");
        System.out.println(bCryptPasswordEncoder.matches("123456", "$2a$10$Mw2QqlCOqhKkWyYLjJWKfOhnPXCZb5CSlpZ9qWixT7/onsX1omPGe"));

        System.out.println("------------------");
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode1 = passwordEncoder.encode("123456");
        System.out.println(encode1);
        System.out.println(passwordEncoder.matches("123456", encode1));
        System.out.println(passwordEncoder.matches("123456", encode1));

        return "添加用户";
    }
}
