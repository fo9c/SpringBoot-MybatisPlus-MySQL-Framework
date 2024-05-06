package cn.fo9c.javaweb_framework.conrtoller;

import cn.fo9c.javaweb_framework.domain.DTO.DemoDTO;
import cn.fo9c.javaweb_framework.domain.PO.DemoPO;
import cn.fo9c.javaweb_framework.domain.Result;
import cn.fo9c.javaweb_framework.domain.VO.DemoVO;
import cn.fo9c.javaweb_framework.mapper.DemoMapper;
import cn.fo9c.javaweb_framework.service.DemoService;
import cn.fo9c.javaweb_framework.utils.SnowFlakeID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


// 使用RestController注解标记这是一个控制器
@RestController
public class DemoController {
    // 使用字段或者构造器注入DemoMapper，实现数据访问
    @Autowired
    private DemoMapper demoMapper;
    @Autowired
    private DemoService demoService;
//    private final DemoMapper demoMapper;
//
//    public DemoController(DemoMapper demoMapper) {
//        this.demoMapper = demoMapper;
//    }

    @GetMapping("/user")
    public List<DemoPO> getDemoList() {
        SnowFlakeID snowFlakeID1 = new SnowFlakeID();
        System.out.println("雪花ID1: " + snowFlakeID1.generator());
        Logger logger = LoggerFactory.getLogger(DemoController.class);
        logger.info("获取用户列表");
        return demoMapper.selectList(null);
    }

    @PostMapping("/user/find")
    public Result<DemoVO> findUserByUid(@RequestBody DemoDTO demoDTO) {
        DemoVO demoVO = demoService.getDemoInfoByUid(demoDTO);
        if (demoVO == null) {
            return Result.error("查询失败",new HashMap<>());
        }
        return Result.success("查询成功", demoVO);
    }

}
